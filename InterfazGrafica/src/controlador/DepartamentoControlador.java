/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class DepartamentoControlador implements Initializable {

    @FXML
    private TextField btnTecAsig;
    @FXML
    private TextField btnDesDep;
    @FXML
    private MenuButton btnMenuButt;
    @FXML
    private Button btnGuardarD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nombreDepartamento(MouseEvent event) {
    }

    @FXML
    private void descripcionDepartamento(MouseEvent event) {
    }

    @FXML
    private void tecnicosAsignados(MouseEvent event) {
    }

    @FXML
    private void guardarDepartamento(MouseEvent event) {
    }
    
}
