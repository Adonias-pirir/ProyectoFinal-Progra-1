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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.scene.Node;
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
import modelo.Departamento;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class DepartamentosControlador implements Initializable {

    @FXML
    private TableView<Departamento> tbDepartamento;
    @FXML
    private Button nuevoDepto;
    @FXML
    private Button modificarDepto;
    @FXML
    private Button eliminarDepto;
    @FXML
    private Button actualizar;
    @FXML
    private TableColumn clNombre;
    @FXML
    private TableColumn clDescrip;
    @FXML
    private TableColumn clTecno;
    
    private ObservableList<Departamento> departamento;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clNombre.setCellValueFactory(new PropertyValueFactory<>("nombreDepto"));
        clDescrip.setCellValueFactory(new PropertyValueFactory<>("descripcionDepto"));
        clTecno.setCellValueFactory(new PropertyValueFactory<>("tecnicoAdo"));
        
        departamento = FXCollections.observableArrayList(); // por si lo quieres cargar desde aquí
        tbDepartamento.setItems(departamento);
    }

   

    @FXML
    private void nuevoDepto(MouseEvent event) {
        try {
            if (departamento == null) {
            departamento = FXCollections.observableArrayList();
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Departamento.fxml"));
            Parent root;
            root = loader.load();
        
            DepartamentoControlador controlador = loader.getController();
            controlador.initAttributtes(departamento);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Departamento d = controlador.getDepartamento();
            if(d != null){
                this.departamento.add(d);
                this.tbDepartamento.refresh();
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
    private void modificarDepto(MouseEvent event) {
        Departamento d = this.tbDepartamento.getSelectionModel().getSelectedItem();
        
        if (d == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una opcion");
            alert.showAndWait();
        }else{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Departamento.fxml"));
            Parent root;
            root = loader.load();
        
            DepartamentoControlador controlador = loader.getController();
            controlador.initAttributtes(departamento, d);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Departamento dt = controlador.getDepartamento();
            if(dt != null){
                this.tbDepartamento.refresh();
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
    private void eliminarDepto(MouseEvent event) {
        Departamento d = this.tbDepartamento.getSelectionModel().getSelectedItem();
        
        if(d == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una opcion");
            alert.showAndWait();
        }else{
            this.departamento.remove(d);
            this.tbDepartamento.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminado exitosamente");
            alert.showAndWait();
        }
    }

    @FXML
    private void actualizarTabla(MouseEvent event) {
    }

    
}
