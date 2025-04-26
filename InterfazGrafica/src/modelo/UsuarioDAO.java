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
public class UsuarioDAO {
    
    // Insertar usuario
    public int insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(nombres, apellidos, email, nombre_usuario, contraseña, rol_asignado, departamento)" + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getNombreUsuario());
            stmt.setString(5, usuario.getContraseña());
            stmt.setString(6, usuario.getRolAsignado());
            stmt.setString(7, usuario.getDepartamento());
            int rowsInserted = stmt.executeUpdate();

        if (rowsInserted > 0) {
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    usuario.setId(generatedId); // opcional: lo actualizas en el objeto
                    return generatedId;
                }
            }
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Error o no se generó ID
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, nombres, apellidos, email, nombre_usuario, contraseña, rol_asignado, departamento FROM usuarios";

        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombres(rs.getString("nombres"));
                u.setApellidos(rs.getString("apellidos"));
                u.setEmail(rs.getString("email"));
                u.setNombreUsuario(rs.getString("nombre_usuario"));
                u.setContraseña(rs.getString("contraseña"));
                u.setRolAsignado(rs.getString("rol_asignado"));
                u.setDepartamento(rs.getString("departamento"));
                lista.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Actualizar usuario
    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombres=?, apellidos=?, email=?, nombre_usuario=?, contraseña=?, rol_asignado=?, departamento=? WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getNombreUsuario());
            stmt.setString(5, usuario.getContraseña());
            stmt.setString(6, usuario.getRolAsignado());
            stmt.setString(7, usuario.getDepartamento());
            stmt.setInt(8, usuario.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Eliminar usuario
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id=?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Buscar usuario por ID
public Usuario buscarUsuarioPorId(int id) {
    String sql = "SELECT * FROM usuarios WHERE id = ?";
    Usuario u = null;

    try (Connection conn = Conexion.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombres(rs.getString("nombres"));
            u.setApellidos(rs.getString("apellidos"));
            u.setEmail(rs.getString("email"));
            u.setNombreUsuario(rs.getString("nombreUsuario"));
            u.setContraseña(rs.getString("contraseña"));
            u.setRolAsignado(rs.getString("rolAsignado"));
            u.setDepartamento(rs.getString("departamento"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return u;
}
}
