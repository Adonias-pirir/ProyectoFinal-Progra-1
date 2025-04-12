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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Usuario;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class UsuarioControlador implements Initializable {

    @FXML
    private TableView<Usuario> tbUs;
    @FXML
    private Button btnNU;
    @FXML
    private Button btnMU;
    @FXML
    private TableColumn clNombres;
    @FXML
    private TableColumn clApellidos;
    @FXML
    private TableColumn clEmail;
    @FXML
    private TableColumn clUsuario;
    @FXML
    private TableColumn clContraseña;
    @FXML
    private TableColumn clRol;
    @FXML
    private TableColumn clDepartamento;
    
    private ObservableList<Usuario> usuario;
    @FXML
    private Button btnElim;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    clNombres.setCellValueFactory(new PropertyValueFactory<>("nombres"));
    clApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));
    clEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    clUsuario.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));
    clContraseña.setCellValueFactory(new PropertyValueFactory<>("contraseña"));
    clRol.setCellValueFactory(new PropertyValueFactory<>("rolAsignado"));
    clDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));

    usuario = FXCollections.observableArrayList(); // por si lo quieres cargar desde aquí
    tbUs.setItems(usuario);
    }    

    @FXML
    private void tbUsuario(MouseEvent event) {
    }

    @FXML
    private void nuevoUsuario(MouseEvent event) {
        try {
            if (usuario == null) {
            usuario = FXCollections.observableArrayList();
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NewUsuario.fxml"));
            Parent root;
            root = loader.load();
        
            NewUsuarioControlador controlador = loader.getController();
            controlador.initAttributtes(usuario);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Usuario us = controlador.getUsuario();
            if(us != null){
                this.usuario.add(us);
                this.tbUs.refresh();
            }
            
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void modificarUsuario(MouseEvent event) {
        Usuario us = this.tbUs.getSelectionModel().getSelectedItem();
        
        if (us == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una opcion");
            alert.showAndWait();
        }else{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NewUsuario.fxml"));
            Parent root;
            root = loader.load();
        
            NewUsuarioControlador controlador = loader.getController();
            controlador.initAttributtes(usuario, us);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Usuario usro = controlador.getUsuario();
            if(usro != null){
                this.tbUs.refresh();
            }
            
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
        }
    }
    
    @FXML
    private void eliminar(MouseEvent event) {
        
        Usuario us = this.tbUs.getSelectionModel().getSelectedItem();
        
        if(us == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una opcion");
            alert.showAndWait();
        }else{
            this.usuario.remove(us);
            this.tbUs.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminado exitosamente");
            alert.showAndWait();
        }
    }
    
}
