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
public class GestionTicketControlador implements Initializable {

    @FXML
    private TableView<?> tbT;
    @FXML
    private Button btnR;
    @FXML
    private Button btnA;
    @FXML
    private Button btnAs;
    @FXML
    private Button btnC;
    @FXML
    private Button btnRea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void listaTicket(MouseEvent event) {
    }

    @FXML
    private void registrar(MouseEvent event) {
    }

    @FXML
    private void actualizar(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ActualizarTicketVista.fxml"));
            
            Parent root;
            root = loader.load();
        
            ActualizarTicketController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(GestionTicketControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void asignar(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ActualizarTicketVista.fxml"));
            
            Parent root;
            root = loader.load();
        
            ActualizarTicketController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            
        } catch (IOException ex) {
            Logger.getLogger(GestionTicketControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cerrarTicket(MouseEvent event) {
    }

    @FXML
    private void reabrir(MouseEvent event) {
    }
    
}
