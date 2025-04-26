/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell Latitude
 */
public class TicketDAO {
    
    private Connection connection;

    public TicketDAO() {
        connection = Conexion.getConnection(); //conectar a la BD
    }

    public boolean insertarTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (usuario_id, descripcion_estado, estado_final, estados_permitidos, fecha_creacion, nombre_estado) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ticket.getUsuarioId());
            stmt.setString(2, ticket.getDescripcionEstado());
            stmt.setString(3, ticket.getEstadoFinal());
            stmt.setString(4, ticket.getEstadosPermitidos());
            stmt.setString(5, ticket.getFechaCreacion());
            stmt.setString(6, ticket.getNombreEstado());
            int filasAfectadas = stmt.executeUpdate();
        if (filasAfectadas > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ticket.setId(rs.getInt(1)); // asignar ID generado
                return true;
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al insertar ticket: " + e.getMessage());
    }
    return false;
}
    
    public List<Ticket> obtenerTickets() {
        List<Ticket> lista = new ArrayList<>();
        String sql = "SELECT * FROM tickets";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setId(rs.getInt("id"));
                t.setUsuarioId(rs.getInt("usuario_id"));
                t.setDescripcionEstado(rs.getString("descripcion_estado"));
                t.setEstadoFinal(rs.getString("estado_final"));
                t.setEstadosPermitidos(rs.getString("estados_permitidos"));
                t.setFechaCreacion(rs.getString("fecha_creacion"));
                t.setNombreEstado(rs.getString("nombre_estado"));
                lista.add(t);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener tickets: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarTicket(Ticket ticket) {
        String sql = "UPDATE tickets SET usuario_id = ?, descripcion_estado = ?, estado_final = ?, estados_permitidos = ?, fecha_creacion = ?, nombre_estado = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, ticket.getUsuarioId());
            stmt.setString(2, ticket.getDescripcionEstado());
            stmt.setString(3, ticket.getEstadoFinal());
            stmt.setString(4, ticket.getEstadosPermitidos());
            stmt.setString(5, ticket.getFechaCreacion()); // o Date.valueOf() si lo cambias
            stmt.setString(6, ticket.getNombreEstado());
            stmt.setInt(7, ticket.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar ticket: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarTicket(int id) {
        String sql = "DELETE FROM tickets WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar ticket: " + e.getMessage());
            return false;
        }
    }
}
