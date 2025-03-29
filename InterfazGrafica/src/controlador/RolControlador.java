/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class RolControlador implements Initializable {

    @FXML
    private AnchorPane bp;
    @FXML
    private TableView<?> tbRol;
    @FXML
    private MenuButton administrador;
    @FXML
    private MenuButton tecnico;
    @FXML
    private MenuButton usuario;
    @FXML
    private Button nuevoRol;
    @FXML
    private Button modificarRol;
    @FXML
    private Button eliminarRol;
    @FXML
    private MenuButton permisos;
    @FXML
    private Button nuevoPermiso;
    @FXML
    private Button asignarPermiso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void NuevoRol(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoRolVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoRolControl controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ModificarRol(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoRolVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoRolControl controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void EliminarRol(MouseEvent event) {
    }

    @FXML
    private void NuevoPermiso(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoRolVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoRolControl controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AsignarPermiso(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoRolVista.fxml"));
            
            Parent root;
            root = loader.load();
        
            NuevoRolControl controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(RolControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadPage(){
        
    }
    
}
