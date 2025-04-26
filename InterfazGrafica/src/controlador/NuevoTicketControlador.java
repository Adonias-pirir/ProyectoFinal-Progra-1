/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Ticket;
import modelo.TicketDAO;
import modelo.Usuario;

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
    @FXML
    private DatePicker fechaCreacion;
    @FXML
    private TextField usuarioId;
    
    //private Usuario usuario;

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
    
    public void initAttributtes(ObservableList<Ticket> tickets, Ticket t){
        this.tickets = tickets;
        this.ticket = t;
        this.nombreEstado.setText(t.getNombreEstado());
        this.descripcionEstado.setText(t.getDescripcionEstado());
        this.estadoFinal.setText(t.getEstadoFinal());
        this.estadosPermitidos.setText(t.getEstadosPermitidos());
        this.fechaCreacion.setValue(LocalDate.parse(t.getFechaCreacion()));
        this.usuarioId.setText(String.valueOf(t.getUsuarioId()));
    }
    
        @FXML
    private void seleccionarEstado(ActionEvent event) {
    MenuItem item = (MenuItem) event.getSource();
    String estado = item.getText();
    estadosPermitidos.setText(estado);
    }
    
    /*public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
}*/

    @FXML
    private void guardar(MouseEvent event) {
        try {
            String nombre = this.nombreEstado.getText();
            String descripcion = this.descripcionEstado.getText();
            String estadoFinal = this.estadoFinal.getText();
            String estadosPermitidos = this.estadosPermitidos.getText();
            String fecha = this.fechaCreacion.getValue().toString();
            //int usuarioId = this.usuario.getId();
            int usuarioId = Integer.parseInt(this.usuarioId.getText());
            //Ticket t = new Ticket(nombreEstado, descripcionEstado, estadoFinal, estadosPermitidos, fechaCreacion, usuarioId);
            Ticket t = new Ticket(nombre, descripcion, estadoFinal, estadosPermitidos, fecha, usuarioId);
            TicketDAO dao = new TicketDAO();

            if (this.ticket != null) {
                // Modificar ticket existente
                this.ticket.setNombreEstado(nombre);
                this.ticket.setDescripcionEstado(descripcion);
                this.ticket.setEstadoFinal(estadoFinal);
                this.ticket.setEstadosPermitidos(estadosPermitidos);
                this.ticket.setFechaCreacion(fecha);
                //this.ticket.setUsuarioId(usuarioId);

                dao.actualizarTicket(this.ticket);
            } else {
                // Insertar nuevo ticket
                dao.insertarTicket(t);
                this.ticket = t;
                this.tickets.add(t);
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Éxito");
            alert.setContentText("Ticket guardado correctamente.");
            alert.showAndWait();

            Stage stage = (Stage) this.guardar.getScene().getWindow();
            stage.close();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Error al guardar el ticket: " + e.getMessage());
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

    @FXML
    private void fechaCreacion(KeyEvent event) {
    }



    
}
