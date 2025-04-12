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
import javafx.scene.control.Alert;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class LoginControlador implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private MenuButton menuBtn;
    @FXML
    private MenuItem op1;
    @FXML
    private MenuItem op2;
    @FXML
    private MenuItem op3;


    /**
     * Initializes the controller class.
     */
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }*/

    private String usuarioSeleccionado = ""; // Para almacenar la opción seleccionada

    @FXML
    private void Ingresar(ActionEvent event) {
        try {
            // Credenciales específicas para cada opción
            String usuario = txtUsuario.getText();
            String password = txtPassword.getText();

            if (validarCredenciales(usuarioSeleccionado, usuario, password)) {
                // Si las credenciales son correctas, abrir la siguiente ventana
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/vista/PrincipalVista.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.show();
                ((Node)event.getSource()).getScene().getWindow().hide();
            } else {
                // Mostrar mensaje de error
                Alert mensaje = new Alert(Alert.AlertType.ERROR);
                mensaje.setTitle("Error");
                mensaje.setContentText("Los datos ingresados son inválidos.");
                mensaje.showAndWait();
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Eventos para capturar la selección del MenuItem
        op1.setOnAction(event -> {
            usuarioSeleccionado = "admin";
            menuBtn.setText("Administrador"); // Cambia el texto del MenuButton
        });

        op2.setOnAction(event -> {
            usuarioSeleccionado = "técnico";
            menuBtn.setText("Técnico");
        });

        op3.setOnAction(event -> {
            usuarioSeleccionado = "usuario";
            menuBtn.setText("Usuario");
        });
    }

    // Método para validar credenciales según la opción seleccionada
    private boolean validarCredenciales(String tipoUsuario, String usuario, String password) {
        switch (tipoUsuario) {
            case "admin":
                return usuario.equals("admin") && password.equals("admin123");
            case "técnico":
                return usuario.equals("tecno") && password.equals("tecno123");
            case "usuario":
                return usuario.equals("user") && password.equals("user123");
            default:
                return false;
        }
    }
}    

    /*@FXML
    private void Ingresar(ActionEvent event) {
        try {
            /*FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PrincipalVista.fxml"));
            
            Parent root;
            root = loader.load();
        
            PrincipalControlador controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODALUNDECORATED);
            stage.setScene(scene);
            stage.showAndWait();*/
            //stage.setOnCloseRequest (e -> controlador.closeWindows());
            
            /*if(txtUsuario.getText().equals("admin") && txtPassword.getText().equals("admin")){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/vista/PrincipalVista.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStile(StageStyle.APPLICATION_MODAL);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }else{
            //System.out.println("Datos invalidos");
            Alert mensaje = new Alert(Alert.AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setContentText("Los datos ingresados son invalidos.");
            mensaje.showAndWait();
        }
        } catch (IOException ex) {
            Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/


    /*@FXML
    private void ingresar(MouseEvent event) throws IOException {
        /*if(txtUsuario.getText().equals("admin") && txtPassword.getText().equals("admin")){
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource(""));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            ((Node)event.getSource()).getScene().getWindow().hide();
        }else{
            System.out.println("Datos invalidos");
        }*/
    //}
    
//}
