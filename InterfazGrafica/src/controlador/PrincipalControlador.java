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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class PrincipalControlador implements Initializable {

    @FXML
    private BorderPane bp;
    @FXML
    private AnchorPane ap;
    @FXML
    private Button btnM;
    @FXML
    private Button btnT;
    @FXML
    private Button btnG;
    @FXML
    private Button lblUsuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblUsuario.setText("-Bienvenido- \n" + Sesion.getTipoUsuario());
    }    



    @FXML
    private void rolesPermisos(MouseEvent event) {
        try {
            Stage actual1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual1.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RolVista.fxml"));
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            //RolControlador controlador = loader.getController();
            //Scene scene = new Scene(root);
            //stage.setScene(scene);
            stage.showAndWait();
            actual1.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registrarDeptos(MouseEvent event) {
        
        try {
            Stage actual2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual2.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Departamentos.fxml"));
            
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            actual2.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void settings(MouseEvent event) {
        try {
            Stage actual = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EmpresaVista.fxml"));
            
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            actual.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void usuarios(MouseEvent event) {
        try {
            Stage actual3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual3.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Usuario.fxml"));
            
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            actual3.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void estadoTicket(MouseEvent event) {
        try {
            Stage actual4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual4.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EstadoTicket.fxml"));
            
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            actual4.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void flujoTrabajo(MouseEvent event) {
        try {
            Stage actual5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual5.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/FlujoTrabajoVista.fxml"));
            
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            actual5.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gestionTickets(MouseEvent event) {
        try {
            Stage actual6 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            actual6.hide();//esconder
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionTicketVista.fxml"));
            
            Parent root = loader.load();
            
            // Crear una nueva ventana
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            actual6.show();
            
        } catch (IOException ex) {
            Logger.getLogger(PrincipalControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void misTicket(MouseEvent event) {
    }

    @FXML
    private void ticketPendientes(MouseEvent event) {
    }

    @FXML
    private void gestionTicket(MouseEvent event) {
    }
    

    
    
}
