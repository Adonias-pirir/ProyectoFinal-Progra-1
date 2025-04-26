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
import modelo.TicketDAO;
import modelo.Usuario;

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
    @FXML
    private TableColumn clId;
    @FXML
    private TableColumn clFecha;
    @FXML
    private TableColumn clUsuarioId;
    private TicketDAO ticketDAO;
    private Usuario usuario;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clId.setCellValueFactory(new PropertyValueFactory<>("id"));
        clNombre.setCellValueFactory(new PropertyValueFactory<>("nombreEstado"));
        clDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcionEstado"));
        clEstado.setCellValueFactory(new PropertyValueFactory<>("estadoFinal"));
        clEstados.setCellValueFactory(new PropertyValueFactory<>("estadosPermitidos"));
        clFecha.setCellValueFactory(new PropertyValueFactory<>("fechaCreacion"));
        clUsuarioId.setCellValueFactory(new PropertyValueFactory<>("usuarioId"));
        
        ticketDAO = new TicketDAO();
        ticket = FXCollections.observableArrayList(ticketDAO.obtenerTickets());
        tbEstadoTicket.setItems(ticket);
        
        cargarTicketsDesdeBD(); // Esto se implementará con el DAO
    }
    
    //public void setUsuario(Usuario usuario) {
    //this.usuario = usuario;
//}    
    private void recargarTabla() {
    ticket.setAll(ticketDAO.obtenerTickets());
}

    private void cargarTicketsDesdeBD() {
        ticketDAO = new TicketDAO();
        ticket.setAll(ticketDAO.obtenerTickets());
    }  

    @FXML
    private void nuevoEstado(MouseEvent event) {
        try {
            if (ticket == null) {
            ticket = FXCollections.observableArrayList();
        }
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoTicketVista.fxml"));
            Parent root = loader.load();
        
            NuevoTicketControlador controlador = loader.getController();
            //controlador.setUsuario(this.usuario);
            controlador.initAttributtes(ticket);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Ticket t = controlador.getTicket();
            if (t != null) {
                recargarTabla();
            } else {
                mostrarError("No se pudo guardar el ticket en la base de datos.");
            }

    } catch (IOException ex) {
        mostrarError("Error al cargar el formulario: " + ex.getMessage());
    }
}

    @FXML
    private void modificarEstado(MouseEvent event) {
        Ticket t = this.tbEstadoTicket.getSelectionModel().getSelectedItem();
        
            if (t == null){
            mostrarError("Debe seleccionar un ticket.");
            return;
        } //else{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoTicketVista.fxml"));
            Parent root = loader.load();
        
            NuevoTicketControlador controlador = loader.getController();
            controlador.initAttributtes(ticket, t);
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
            Ticket ta = controlador.getTicket();
            if (ta != null) {
            ticketDAO = new TicketDAO();
            boolean exito = ticketDAO.actualizarTicket(ta);
            if (exito) {
                recargarTabla();
            } else {
                mostrarError("No se pudo actualizar el ticket en la base de datos.");
            }
        }

    } catch (IOException ex) {
        mostrarError("Error al cargar el formulario: " + ex.getMessage());
    }
}

    @FXML
    private void eliminarEstado(MouseEvent event) {
        Ticket t = tbEstadoTicket.getSelectionModel().getSelectedItem();
        
        if(t == null){
            mostrarError("Debe seleccionar un ticket.");
            return;
        }//else{
        ticketDAO = new TicketDAO();
        if (ticketDAO.eliminarTicket(t.getId())) {
            ticket.remove(t);
            recargarTabla();
        } else {
            mostrarError("No se pudo eliminar el ticket.");
        }
            /*this.ticket.remove(t);
            this.tbEstadoTicket.refresh();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Eliminado exitosamente");
            alert.showAndWait();*/
        
    }
    
    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void actualizar(MouseEvent event) {
    }
    
}
