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
public class NuevoRol {
    
        private String nombreRol;
        private String descripRol;
        private String nombrePermiso;
        private String descripPermiso;

    public NuevoRol(String nombreRol, String descripRol, String nombrePermiso, String descripPermiso) {
        this.nombreRol = nombreRol;
        this.descripRol = descripRol;
        this.nombrePermiso = nombrePermiso;
        this.descripPermiso = descripPermiso;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripRol() {
        return descripRol;
    }

    public void setDescripRol(String descripRol) {
        this.descripRol = descripRol;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getDescripPermiso() {
        return descripPermiso;
    }

    public void setDescripPermiso(String descripPermiso) {
        this.descripPermiso = descripPermiso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final NuevoRol other = (NuevoRol) obj;
        if (!Objects.equals(this.nombreRol, other.nombreRol)) {
            return false;
        }
        if (!Objects.equals(this.descripRol, other.descripRol)) {
            return false;
        }
        if (!Objects.equals(this.nombrePermiso, other.nombrePermiso)) {
            return false;
        }
        return Objects.equals(this.descripPermiso, other.descripPermiso);
    }
        
        
    
}
