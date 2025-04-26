/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Dell Latitude
 */
public class Sesion {
    
    private static String tipoUsuario;
    
    public static void setTipoUsuario(String tipo){
        tipoUsuario = tipo;
    }
    
    public static String getTipoUsuario(){
        return tipoUsuario;
    }
    
}
