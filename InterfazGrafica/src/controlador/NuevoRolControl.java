/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.NuevoRol;

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
    private NuevoRol rol;
    
    private ObservableList<NuevoRol> nuevoRol;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void initAttributtes(ObservableList<NuevoRol> nuevoRol){
        this.nuevoRol = nuevoRol;
    }
    
    public void initAttributtes(ObservableList<NuevoRol> nuevoRol, NuevoRol nr){
        this.nuevoRol = nuevoRol;
        this.rol = nr;
        this.nombreRol.setText(nr.getNombreRol());
        this.descripRol.setText(nr.getDescripRol());
        this.nombrePermiso.setText(nr.getNombrePermiso());
        this.descripPermiso.setText(nr.getDescripPermiso());
    }

    @FXML
    private void guardarRol(ActionEvent event) {
        
        String nombreRol = this.nombreRol.getText();
        String descripRol = this.descripRol.getText();
        String nombrePermiso = this.nombrePermiso.getText();
        String descripPermiso = this.descripPermiso.getText();
        
        NuevoRol nr = new NuevoRol(nombreRol, descripRol, nombrePermiso, descripPermiso);
      
        if(!nuevoRol.contains(nr)){
            //modificar
            
            if (this.rol != null){
                this.rol.setNombreRol(nombreRol);
                this.rol.setDescripRol(descripRol);
                this.rol.setNombrePermiso(nombrePermiso);
                this.rol.setDescripPermiso(descripPermiso);
                
            }else{
                //insertando
            this.rol = nr;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Informacion");
            alert.setContentText("Se ha añadido correctamente");
            alert.showAndWait();
            }
            
            
            Stage stage = (Stage) this.guardarRol.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ya existe");
            alert.showAndWait();

        }
    }


    public NuevoRol getRol() {
        return rol;
    }

    @FXML
    private void Salir(ActionEvent event) {
        this.rol = null;
        Stage stage = (Stage) this.guardarRol.getScene().getWindow();
            stage.close();
    }
    
    
    
}
