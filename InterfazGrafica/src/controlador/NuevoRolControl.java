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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class NuevoRolControl implements Initializable {

    @FXML
    private AnchorPane bpRol;
    @FXML
    private TextField nombreRol;
    @FXML
    private TextField descripRol;
    @FXML
    private TextField nombrePermiso;
    @FXML
    private TextField descripPermiso;
    @FXML
    private Button guardarRol;
    @FXML
    private Button guardarPermiso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
