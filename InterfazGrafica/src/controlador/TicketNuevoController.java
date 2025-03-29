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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class TicketNuevoController implements Initializable {

    @FXML
    private TextField btnT;
    @FXML
    private TextField btnD;
    @FXML
    private MenuButton btnDep;
    @FXML
    private MenuButton btnN;
    @FXML
    private ImageView img;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void titulo(MouseEvent event) {
    }

    @FXML
    private void descripcion(MouseEvent event) {
    }

    @FXML
    private void departamentoAsignado(MouseEvent event) {
    }

    @FXML
    private void nivelPrioridad(MouseEvent event) {
    }
    
}
