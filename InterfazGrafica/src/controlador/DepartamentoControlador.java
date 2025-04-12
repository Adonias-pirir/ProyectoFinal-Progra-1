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
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelo.Departamento;


/**
 * FXML Controller class
 *
 * @author Dell Latitude
 */
public class DepartamentoControlador implements Initializable {

    @FXML
    private Button guardarDepto;
    @FXML
    private TextField nombreDepto;
    @FXML
    private MenuButton tecnicoAdo;
    @FXML
    private TextArea descripcionDepto;
    private Departamento departamento;
    
    private ObservableList<Departamento> departamentos;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void initAttributtes(ObservableList<Departamento> departamentos){
        this.departamentos = departamentos;
    }
    
    public void initAttributtes(ObservableList<Departamento> departamentos, Departamento d){
        this.departamentos = departamentos;
        this.departamento = d;
        this.nombreDepto.setText(d.getNombreDepto());
        this.descripcionDepto.setText(d.getDescripcionDepto());
        this.tecnicoAdo.setText(d.getTecnicoAdo());
    }
    
    @FXML
    private void seleccionarUsuario(ActionEvent event) {
    MenuItem item = (MenuItem) event.getSource();
    String nombreTecnico = item.getText();
    tecnicoAdo.setText(nombreTecnico);
    }
 

    @FXML
    private void tecnicosAsignados(MouseEvent event) {
    }

    @FXML
    private void guardarDepto(ActionEvent event) {
        String nombreDepto = this.nombreDepto.getText();
        String descripcionDepto = this.descripcionDepto.getText();
        String tecnicoAdo = this.tecnicoAdo.getText();
        
        Departamento d = new Departamento(nombreDepto, descripcionDepto, tecnicoAdo);
        
        if(!departamentos.contains(d)){
            //modificar
            
            if(this.departamento != null){
                this.departamento.setNombreDepto(nombreDepto);
                this.departamento.setDescripcionDepto(descripcionDepto);
                this.departamento.setTecnicoAdo(tecnicoAdo);
            }else{
                //insertando
                this.departamento = d;
                //this.departamentos.add(d);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("Se ha agregado correctamente");
                alert.showAndWait();
            }
            
            Stage stage = (Stage) this.guardarDepto.getScene().getWindow();
            stage.close();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Ya existe");
            alert.showAndWait();
            
        }
    }
    
    public Departamento getDepartamento(){
        return departamento;
    }    

    
}
