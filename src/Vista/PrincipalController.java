/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Recurso;
import Modelo.Hora;
import Principal.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private DatePicker calendario;
    @FXML
    private Button nuevo;
    @FXML
    private Button eliminar;
    @FXML
    private Button solicitar;
    @FXML
    private Button borrar;
    
    private MainApp mainApp;
    
    public PrincipalController()
    {      
    }
    
    public void initialize()
    {
        recursoColumn.setCellValueFactory(cellData -> cellData.getValue().nombre());
        horasColumn.setCellValueFactory(cellData -> cellData.getValue().getHora());
        libreColumn.setCellValueFactory(cellData -> cellData.getValue().getLibre());
        
        //recursoTable.getSelectionModel().selectedItemProperty().addListener(
            //(observable, oldValue, newValue) -> showResourceDetails(newValue);
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        recursoTable.setItems(mainApp.getDatosRecursos());
    }
}
