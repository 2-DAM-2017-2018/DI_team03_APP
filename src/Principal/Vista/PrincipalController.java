/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Vista;

import Modelo.Fecha;
import Modelo.Recurso;
import Modelo.Hora;
import Principal.MainApp;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
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
                
        /*Recurso r = recursoTable.getSelectionModel().getSelectedItem();
        rellenarTablaHoras(r);*/
        //recursoTable.getSelectionModel().selectedItemProperty().addListener(
        //(observable, oldValue, newValue) -> rellenarTablaHoras(newValue));
    }    
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        
        recursoTable.setItems(mainApp.getDatosRecursos());
        eliminar.setDisable(true);
        solicitar.setDisable(true);
        anular.setDisable(true);
    }

    public void rellenarTablaHoras(Recurso recurso)
    {
        if(recurso != null)
        {
            String fecha = String.valueOf(calendario.getValue());
            
            if(recurso.comprobarFecha(fecha) == -1) {
                Fecha f = new Fecha(fecha);
                recurso.addFecha(f);
            }
            ObservableList<Hora> horas = recurso.getFecha(recurso.comprobarFecha(fecha)).getHorario();
            
            horarioTable.setItems(horas);
            horasColumn.setCellValueFactory(cellData -> cellData.getValue().getHoraProperty());
            libreColumn.setCellValueFactory(cellData -> cellData.getValue().getLibreProperty());
            horarioTable.refresh();
        }
    }
    
    @FXML
    private void botonNuevo()
    {
        Recurso tempRecurso = new Recurso();
        boolean okClicked = mainApp.mostrarEditarRecurso(tempRecurso);
        if (okClicked) 
        {
            mainApp.getDatosRecursos().add(tempRecurso);
        }
    }
    @FXML
    private void actionCalendario(){
        Recurso recurso = recursoTable.getSelectionModel().getSelectedItem();
        rellenarTablaHoras(recurso);
        System.out.println("accion");
    }
        
    @FXML
    private void botonEliminar()
    {
        int selectedIndex = recursoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            recursoTable.getItems().remove(selectedIndex);
            horarioTable.setItems(null);
            eliminar.setDisable(true);
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
    private void comprobarRecurso() {
        int selectedIndex = recursoTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            eliminar.setDisable(false);
        }
    }
    
    @FXML
    private void comprobarHora() {
        int selectedIndex = horarioTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Hora s = horarioTable.getSelectionModel().getSelectedItem();
            if("Si".equals(s.getLibre())) {
                solicitar.setDisable(false);
                anular.setDisable(true);
            } else {
                solicitar.setDisable(true);
                anular.setDisable(false);
            }
        }
    }
        
    
    @FXML
    private void botonSolicitar()
    {
        int selectedIndex = horarioTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0)
        {
            Recurso r = recursoTable.getSelectionModel().getSelectedItem();
            
            String fecha = String.valueOf(calendario.getValue());
            
            
            r.getFecha(r.comprobarFecha(fecha)).getHora(selectedIndex).setLibre(new SimpleStringProperty("No"));
            r.getFecha(r.comprobarFecha(fecha)).setHora(r.getFecha(r.comprobarFecha(fecha)).getHora(selectedIndex), selectedIndex);
            /*Hora s = horarioTable.getSelectionModel().getSelectedItem();
            StringProperty libre = new SimpleStringProperty("No");
            s.setLibre(libre);*/
            rellenarTablaHoras(r);
            horarioTable.refresh();
            solicitar.setDisable(true);
            anular.setDisable(false);
            System.out.println(calendario.getValue());
        }
        else 
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sin seleccióin");
            alert.setHeaderText("No hay horas seleccionadas");
            alert.setContentText("Porfavor selecciona una hora de la tabla");

            alert.showAndWait();
        }
    }
    
    @FXML
    private void botonAnular()
    {
        int selectedIndex = horarioTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0)
        {
            Hora s = horarioTable.getSelectionModel().getSelectedItem();
            StringProperty libre = new SimpleStringProperty("Si");
            s.setLibre(libre);
            horarioTable.refresh();
            solicitar.setDisable(false);
            anular.setDisable(true);
        }
        else 
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Sin seleccióin");
            alert.setHeaderText("No hay horas seleccionadas");
            alert.setContentText("Porfavor selecciona una hora de la tabla");
            
            alert.showAndWait();
        }
    }
}
