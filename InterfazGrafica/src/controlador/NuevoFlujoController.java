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
public class NuevoFlujoController implements Initializable {

    @FXML
    private TextField txtNF;
    @FXML
    private MenuButton btnE;
    @FXML
    private Button btnA;
    @FXML
    private Button btnC;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nombreFlujo(MouseEvent event) {
    }

    @FXML
    private void estadosInv(MouseEvent event) {
    }

    @FXML
    private void agregar(MouseEvent event) {
    }

    @FXML
    private void cancelar(MouseEvent event) {
    }
    
}
