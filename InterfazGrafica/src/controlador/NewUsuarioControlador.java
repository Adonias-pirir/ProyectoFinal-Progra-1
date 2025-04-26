/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class NewUsuarioControlador implements Initializable {
    @FXML
    private Button btnCan;
    @FXML
    private TextField nombres;
    @FXML
    private TextField contraseña;
    @FXML
    private TextField nombreUsuario;
    @FXML
    private TextField email;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField departamento;
    @FXML
    private TextField rolAsignado;
    @FXML
    private Button registrar;
    
    private Usuario usuario;
    private ObservableList<Usuario> usuarios;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initAttributtes(ObservableList<Usuario> usuarios){
        this.usuarios = usuarios;
    }
    
    public void initAttributtes(ObservableList<Usuario> usuarios, Usuario us){
        this.usuarios = usuarios;
        this.usuario = us;
        this.nombres.setText(us.getNombres());
        this.apellidos.setText(us.getApellidos());
        this.email.setText(us.getEmail());
        this.nombreUsuario.setText(us.getNombreUsuario());
        this.contraseña.setText(us.getContraseña());
        this.rolAsignado.setText(us.getRolAsignado());
        this.departamento.setText(us.getDepartamento());
    }

    @FXML
    private void registrar(MouseEvent event) {
        String nombres = this.nombres.getText();
        String apellidos = this.apellidos.getText();
        String email = this.email.getText();
        String nombreUsuario = this.nombreUsuario.getText();
        String contraseña = this.contraseña.getText();
        String rolAsignado = this.rolAsignado.getText();
        String departamento = this.departamento.getText();
        
        Usuario us = new Usuario(nombres, apellidos, email, nombreUsuario, contraseña, rolAsignado, departamento);
        
        if(!usuarios.contains(us)){
            //modificar
            
            if (this.usuario != null){
                this.usuario.setNombres(nombres);
                this.usuario.setApellidos(apellidos);
                this.usuario.setEmail(email);
                this.usuario.setNombreUsuario(nombreUsuario);
                this.usuario.setContraseña(contraseña);
                this.usuario.setRolAsignado(rolAsignado);
                this.usuario.setDepartamento(departamento);
                
            }else{
                //insertando la modificacion
            this.usuario = us;
            //this.usuarios.add(us);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Se ha añadido correctamente");
            alert.showAndWait();
            }
            
            
            Stage stage = (Stage) this.registrar.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ya existe");
            alert.showAndWait();

        }
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    @FXML
    private void cancelar(MouseEvent event) {
        this.usuario = null;
        Stage stage = (Stage) this.registrar.getScene().getWindow();
            stage.close();
    }

    
    
}
