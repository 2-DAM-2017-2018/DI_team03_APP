/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Vista;

import Principal.MainApp;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 * La clase RootLayoutController controla la ventana RootLayout
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
public class RootLayoutController {

    private MainApp mainApp;

    /**
     * Modifica el objeto mainApp
     * @param mainApp mainApp que le pasamos por parámetro
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    /**
     * Acción que realiza el menú Nuevo
     */
    @FXML
    private void handleNew() {
        mainApp.getDatosRecursos().clear();
        mainApp.setRecursoFilePath(null);
    }
    
    /**
     * Acción que realiza el menú Cargar
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadDatosRecursoFromFile(file);
        }
    }

    /**
     * Acción que realiza el menú Guardar
     */
    @FXML
    private void handleSave() {
        File recursoFile = mainApp.getRecursoFilePath();
        if (recursoFile != null) {
            mainApp.saveDatosRecursoToFile(recursoFile);
        } else {
            handleSaveAs();
        }
    }
    
    /**
     * Acción que realiza el menú Guardar como
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveDatosRecursoToFile(file);
        }
    }
    
    /**
     * Acción que realiza el menú Sobre
     */
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de");
        alert.setHeaderText(null);
        alert.setContentText("Autores: \n\tAlejandro Ariza\n\tFelipe Pérez");

        alert.showAndWait();
    }
    
    /**
     * Acción que realiza el menú Salir
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
