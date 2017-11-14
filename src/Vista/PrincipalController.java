/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Recurso;
import Modelo.Hora;
import Principal.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Felipe Pérez Sillero
 */
public class PrincipalController
{
    @FXML
    private TableView<Recurso> recursoTable;
    @FXML
    private TableColumn<Recurso, String> recursoColumn;
    @FXML
    private TableView<Hora> horarioTable;
    @FXML
    private TableColumn<Hora, String> horasColumn;
    @FXML
    private TableColumn<Hora, String> libreColumn;
    
    @FXML
    private RadioButton salas;
    @FXML
    private RadioButton herramientas;
    @FXML
    private DatePicker calendario;
    @FXML
    private Button nuevo;
    @FXML
    private Button eliminar;
    @FXML
    private Button solicitar;
    @FXML
    private Button borrar;
    
    private final ToggleGroup group = new ToggleGroup(); 
    private MainApp mainApp;
    
    public PrincipalController()
    {      
    }
    
    public void initialize(){
        // TODO
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
}
