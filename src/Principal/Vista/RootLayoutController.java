/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal.Vista;

import Principal.MainApp;
import java.io.File;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class RootLayoutController {

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void handleNew() {
        mainApp.getDatosRecursos().clear();
        mainApp.setRecursoFilePath(null);
    }
    
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

    @FXML
    private void handleSave() {
        File recursoFile = mainApp.getRecursoFilePath();
        if (recursoFile != null) {
            mainApp.saveDatosRecursoToFile(recursoFile);
        } else {
            handleSaveAs();
        }
    }
    
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
    
    @FXML
    private void handleAbout() {
        Dialogs.create()
            .title("Reservar Recurso")
            .masthead("Sobre")
            .message("Autores: \n\tAlejandro Ariza\n\tFelipe Pérez")
            .showInformation();
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
   @FXML
   private void handleShowPieChart() {
     //mainApp.showPieChart();
   }
}