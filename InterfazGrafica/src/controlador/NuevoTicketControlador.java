/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Ticket;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class NuevoTicketControlador implements Initializable {

    @FXML
    private TextField nombreEstado;
    @FXML
    private TextField estadoFinal;
    @FXML
    private TextField descripcionEstado;
    @FXML
    private MenuButton estadosPermitidos;
    @FXML
    private Button guardar;
    @FXML
    private Button cancelar;
    
    private Ticket ticket;
    
    private ObservableList<Ticket> tickets;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        public void initAttributtes(ObservableList<Ticket> tickets){
        this.tickets = tickets;
    }
    
    public void initAttributtes(ObservableList<Ticket> departamentos, Ticket t){
        this.tickets = departamentos;
        this.ticket = t;
        this.nombreEstado.setText(t.getNombreEstado());
        this.descripcionEstado.setText(t.getDescripcionEstado());
        this.estadoFinal.setText(t.getEstadoFinal());
        this.estadosPermitidos.setText(t.getEstadosPermitidos());
    }
    
        @FXML
    private void seleccionarEstado(ActionEvent event) {
    MenuItem item = (MenuItem) event.getSource();
    String nombreEstado = item.getText();
    estadosPermitidos.setText(nombreEstado);
    }


    @FXML
    private void guardar(MouseEvent event) {
        String nombreEstado = this.nombreEstado.getText();
        String descripcionEstado = this.descripcionEstado.getText();
        String estadoFinal = this.estadoFinal.getText();
        String estadosPermitidos = this.estadosPermitidos.getText();
        
        Ticket t = new Ticket(nombreEstado, descripcionEstado, estadoFinal, estadosPermitidos);
        
        if(!tickets.contains(t)){
            //modificar
            
            if(this.ticket != null){
                this.ticket.setNombreEstado(nombreEstado);
                this.ticket.setDescripcionEstado(descripcionEstado);
                this.ticket.setEstadoFinal(estadoFinal);
                this.ticket.setEstadosPermitidos(estadosPermitidos);
            }else{
                //insertando
                this.ticket = t;
                //this.departamentos.add(d);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Se ha agregado correctamente");
                alert.showAndWait();
            }
            
            Stage stage = (Stage) this.guardar.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ya existe");
            alert.showAndWait();
            
        }
        
    }
    
    public Ticket getTicket(){
        return ticket;
    }

    @FXML
    private void cancelar(MouseEvent event) {
         this.ticket = null;
        Stage stage = (Stage) this.guardar.getScene().getWindow();
        stage.close();
    }


    @FXML
    private void estadosPermitidos(MouseEvent event) {
    }



    
}
