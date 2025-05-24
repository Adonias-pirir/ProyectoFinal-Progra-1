/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Dell Latitude
 */
public class Persona {
    
    private String nombre;
    private String nombreUsuario;
    private String departamento;
    private String contraseña;
    private String correo;
    private String rol;
    private String identificacion;
    
    public Persona(){
        
    }
    
    public Persona (String nombre, String nombreUsuario, String departamento, String contraseña, String correo, String rol, String identificacion){
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.departamento = departamento;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
        this.identificacion = identificacion;
    }
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
    }
    
    public String getDepartamento(){
        return departamento;
    }
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }
    
    public String getContraseña(){
        return contraseña;
    }
    public void setContraseña (String contraseña){
        this.contraseña = contraseña;
    }
    
    public String getCorreo(){
        return correo;
    }
    public void setCorreo(String correo){
        this.correo = correo;
    }
    
    public String getRol(){
        return rol;
    }
    public void setRol(String rol){
        this.rol = rol;
    }
    
    public String setIdentificacion(){
        return identificacion;
    }
    public void getIdentificacion(String identificacion){
        this.identificacion = identificacion;
    }
    
    public void mensaje(){
        System.out.println("Aplicadno Herencia");
    }
}