/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Vista;

import Modelo.Recurso;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 * La clase EditarRecursoController controla la ventana de crear recurso
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
public class EditarRecursoController {

    @FXML
    private TextField idField;
    @FXML
    private TextField nombreField;
    
    private Stage dialogStage;
    private Recurso recurso;
    private boolean okClicked = false;
    
    /**
     * Método que se ejecuta al inizializar la clase
     */
    @FXML
    private void initialize() {
    }    
    
    /**
     * Modifica el campo de texto
     * @param dialogStage texto que le pasamos por parámetro
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    /**
     * Modifica el nombre y el id del recurso
     * @param recurso recurso que le pasamos por parámetro
     */
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;

        idField.setText(String.valueOf(recurso.getId()));
        nombreField.setText(recurso.getNombre());
    }
    
    /**
     * Comprueba si clickas el botón Ok
     * @return devuelve verdadero o falso
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Acción que realiza el botón Ok
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            recurso.setId(Integer.valueOf(idField.getText()));
            recurso.setNombre(nombreField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
    
    /**
     * Acción que realiza el botón Cancelar
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (idField.getText() == null || idField.getText().length() == 0) {
            errorMessage += "Id no válido\n"; 
        }
        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "El nombre no es válido\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos incorrectos");
            alert.setHeaderText("Por favor corrija los campos incorrectos.");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
