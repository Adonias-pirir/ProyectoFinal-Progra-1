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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class FlujoTrabajoController implements Initializable {

    @FXML
    private TableView<?> tbF;
    @FXML
    private Button btnN;
    @FXML
    private Button btnM;
    @FXML
    private Button btnE;
    @FXML
    private Button btnE1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tablaFlujo(MouseEvent event) {
    }

    @FXML
    private void nuevoFlujo(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoFlujoVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoFlujoController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(FlujoTrabajoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modificarFlujo(MouseEvent event) {
    }

    @FXML
    private void eliminarFlujo(MouseEvent event) {
    }

    @FXML
    private void guardarFlujos(MouseEvent event) {
    }
    
}
