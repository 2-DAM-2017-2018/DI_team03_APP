/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Principal.MainApp;
import javafx.fxml.FXML;

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
        mainApp.setPersonFilePath(null);
    }

}
