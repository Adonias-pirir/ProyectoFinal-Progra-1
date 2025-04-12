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
import modelo.Ticket;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class EstadoTicketControlador implements Initializable {

    @FXML
    private Button btnN;
    @FXML
    private Button btnM;
    @FXML
    private Button btnE;
    @FXML
    private Button btnA;
    @FXML
    private TableColumn clNombre;
    @FXML
    private TableColumn clDescripcion;
    @FXML
    private TableColumn clEstado;
    @FXML
    private TableColumn clEstados;
    @FXML
    private TableView<Ticket> tbEstadoTicket;
    
    private ObservableList<Ticket> ticket;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clNombre.setCellValueFactory(new PropertyValueFactory<>("nombreEstado"));
        clDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionEstado"));
        clEstado.setCellValueFactory(new PropertyValueFactory<>("estadoFinal"));
        clEstados.setCellValueFactory(new PropertyValueFactory<>("estadosPermitidos"));
        
        ticket = FXCollections.observableArrayList(); // por si lo quieres cargar desde aquí
        tbEstadoTicket.setItems(ticket);
    }    

    @FXML
    private void nuevoEstado(MouseEvent event) {
        try {
            if (ticket == null) {
            ticket = FXCollections.observableArrayList();
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoTicketVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoTicketControlador controlador = loader.getController();
            controlador.initAttributtes(ticket);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Ticket t = controlador.getTicket();
            if(t != null){
                this.ticket.add(t);
                this.tbEstadoTicket.refresh();
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
    private void modificarEstado(MouseEvent event) {
        Ticket t = this.tbEstadoTicket.getSelectionModel().getSelectedItem();
        
            if (t == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe seleccionar una opcion");
            alert.showAndWait();
        }else{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoTicketVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoTicketControlador controlador = loader.getController();
            controlador.initAttributtes(ticket, t);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Ticket tc = controlador.getTicket();
            if(tc != null){
                //this.ticket.add(t);
                this.tbEstadoTicket.refresh();
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
    private void eliminarEstado(MouseEvent event) {
        Ticket t = this.tbEstadoTicket.getSelectionModel().getSelectedItem();
        
        if(t == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes seleccionar una opcion");
            alert.showAndWait();
        }else{
            this.ticket.remove(t);
            this.tbEstadoTicket.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminado exitosamente");
            alert.showAndWait();
        }
    }

    @FXML
    private void actualizar(MouseEvent event) {
    }
    
}
