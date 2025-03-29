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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevoEstado(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/NuevoTicketVista.fxml"));
            Parent root;
            root = loader.load();
        
            NuevoTicketControlador controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(EstadoTicketControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modificarEstado(MouseEvent event) {
    }

    @FXML
    private void eliminarEstado(MouseEvent event) {
    }

    @FXML
    private void actualizar(MouseEvent event) {
    }
    
}
