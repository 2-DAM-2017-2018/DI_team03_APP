/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Recurso;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alejandro
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
     * Initializes the controller class.
     */
    @FXML
    private void initialize() {
    }    
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;

        idField.setText(String.valueOf(recurso.getId()));
        nombreField.setText(recurso.getNombre());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            recurso.setId(Integer.valueOf(idField.getText()));
            recurso.setNombre(nombreField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }
    
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
