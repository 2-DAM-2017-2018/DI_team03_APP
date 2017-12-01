/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Vista;

import Modelo.Recurso;
import Modelo.Hora;
import Principal.MainApp;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private Button anular;
    
    private MainApp mainApp;
    
    public PrincipalController()
    {
    }
    
    public void initialize()
    {
        recursoColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
                
        recursoTable.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> rellenarTablaHoras(newValue));
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        recursoTable.setItems(mainApp.getDatosRecursos());
    }
    
    public void rellenarTablaHoras(Recurso recurso)
    {
        if(recurso != null)
        {
            horarioTable.setItems(mainApp.getHoras());
            horasColumn.setCellValueFactory(cellData -> cellData.getValue().getHoraProperty());
            libreColumn.setCellValueFactory(cellData -> cellData.getValue().getLibreProperty());
        }
    }
    
    @FXML
    private void botonNuevo()
    {
        Recurso tempRecurso = new Recurso();
        boolean okClicked = mainApp.mostrarEditarRecurso(tempRecurso);
        if (okClicked) {
            mainApp.getDatosRecursos().add(tempRecurso);
        }
    }
    
    @FXML
    private void botonEliminar()
    {
        int selectedIndex = recursoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            recursoTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sin seleccióin");
            alert.setHeaderText("No hay recursos seleccionados");
            alert.setContentText("Porfavor selecciona un recurso de la tabla");

            alert.showAndWait();
        }
    }
        
    
    @FXML
    private void botonSolicitar()
    {
        
    }
    
    @FXML
    private void botonAnular()
    {
        
    }
}
