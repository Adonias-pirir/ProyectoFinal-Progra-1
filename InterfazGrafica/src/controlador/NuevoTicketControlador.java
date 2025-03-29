/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class NuevoTicketControlador implements Initializable {

    @FXML
    private TextField btnN;
    @FXML
    private TextField btnE;
    @FXML
    private TextField btnD;
    @FXML
    private MenuButton btnEPS;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nombreEstado(MouseEvent event) {
    }

    @FXML
    private void estadoFinal(MouseEvent event) {
    }

    @FXML
    private void Descripcion(MouseEvent event) {
    }

    @FXML
    private void guardar(MouseEvent event) {
    }

    @FXML
    private void estadoPermitido(MouseEvent event) {
    }
    
}
