/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Dell Latitude
 */
public class Ticket {
    
    private int id;
    private String nombreEstado;
    private String descripcionEstado;
    private String estadoFinal;
    private String estadosPermitidos;
    private String fechaCreacion;
    private int usuarioId;
    
    public Ticket() {}

    public Ticket(String nombreEstado, String descripcionEstado, String estadoFinal, String estadosPermitidos, String fechaCreacion, int usuarioId) {
    this.nombreEstado = nombreEstado;
    this.descripcionEstado = descripcionEstado;
    this.estadoFinal = estadoFinal;
    this.estadosPermitidos = estadosPermitidos;
    this.fechaCreacion = fechaCreacion;
    this.usuarioId = usuarioId;
}
    
    public int getId() { 
        return id;
    }
    public void setId(int id) { 
        this.id = id;
    }
    
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

    public String getEstadoFinal() {
        return estadoFinal;
    }

    public void setEstadoFinal(String estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public String getEstadosPermitidos() {
        return estadosPermitidos;
    }

    public void setEstadosPermitidos(String estadosPermitidos) {
        this.estadosPermitidos = estadosPermitidos;
    }
    
    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (!Objects.equals(this.nombreEstado, other.nombreEstado)) {
            return false;
        }
        if (!Objects.equals(this.descripcionEstado, other.descripcionEstado)) {
            return false;
        }
        if (!Objects.equals(this.estadoFinal, other.estadoFinal)) {
            return false;
        }
        if (!Objects.equals(this.estadosPermitidos, other.estadosPermitidos)) {
            return false;
        }
        return Objects.equals(this.fechaCreacion, other.fechaCreacion);
    }
    
}
