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
public class Departamento {
    
    private String nombreDepto;
    private String descripcionDepto;
    private String tecnicoAdo;

    public Departamento(String nombreDepto, String descripcionDepto, String tecnicoAdo) {
        this.nombreDepto = nombreDepto;
        this.descripcionDepto = descripcionDepto;
        this.tecnicoAdo = tecnicoAdo;
    }

    public String getNombreDepto() {
        return nombreDepto;
    }

    public void setNombreDepto(String nombreDepto) {
        this.nombreDepto = nombreDepto;
    }

    public String getDescripcionDepto() {
        return descripcionDepto;
    }

    public void setDescripcionDepto(String descripcionDepto) {
        this.descripcionDepto = descripcionDepto;
    }

    public String getTecnicoAdo() {
        return tecnicoAdo;
    }

    public void setTecnicoAdo(String tecnicoAdo) {
        this.tecnicoAdo = tecnicoAdo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Departamento other = (Departamento) obj;
        if (!Objects.equals(this.nombreDepto, other.nombreDepto)) {
            return false;
        }
        if (!Objects.equals(this.descripcionDepto, other.descripcionDepto)) {
            return false;
        }
        return Objects.equals(this.tecnicoAdo, other.tecnicoAdo);
    }
    
    
    
}
