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
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.NuevoRol;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class RolControlador implements Initializable {

    @FXML
    private AnchorPane bp;
    @FXML
    private MenuButton administrador;
    @FXML
    private Button nuevoRol;
    @FXML
    private Button modificarRol;
    @FXML
    private Button eliminarRol;
    @FXML
    private MenuButton permisos;
    @FXML
    private TableView<NuevoRol> tbRolesPermisos;
    @FXML
    private TableColumn clRol;
    @FXML
    private TableColumn clRDes;
    @FXML
    private TableColumn clPer;
    @FXML
    private TableColumn clPDes;
    
    private ObservableList<NuevoRol> rol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    clRol.setCellValueFactory(new PropertyValueFactory<>("nombreRol"));
    clRDes.setCellValueFactory(new PropertyValueFactory<>("descripRol"));
    clPer.setCellValueFactory(new PropertyValueFactory<>("nombrePermiso"));
    clPDes.setCellValueFactory(new PropertyValueFactory<>("descripPermiso"));

    rol = FXCollections.observableArrayList(); // por si lo quieres cargar desde aquí
    tbRolesPermisos.setItems(rol);
    }    

    @FXML
    private void NuevoRol(MouseEvent event) {
        try {
            if (rol == null) {
            rol = FXCollections.observableArrayList();
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoRolVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoRolControl controlador = loader.getController();
            controlador.initAttributtes(rol);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            NuevoRol nr = controlador.getRol();
            if(nr != null){
                this.rol.add(nr);
                this.tbRolesPermisos.refresh();
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
    private void ModificarRol(MouseEvent event) {
        NuevoRol nr = this.tbRolesPermisos.getSelectionModel().getSelectedItem();
        
        if (nr == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una opcion");
            alert.showAndWait();
        }else{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoRolVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoRolControl controlador = loader.getController();
            controlador.initAttributtes(rol, nr);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            NuevoRol rn = controlador.getRol();
            if(rn != null){
                this.tbRolesPermisos.refresh();
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
    private void EliminarRol(MouseEvent event) {
        
        NuevoRol nr = this.tbRolesPermisos.getSelectionModel().getSelectedItem();
        
        if(nr == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una opcion");
            alert.showAndWait();
        }else{
            this.rol.remove(nr);
            this.tbRolesPermisos.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminado exitosamente");
            alert.showAndWait();
        }
    }

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
