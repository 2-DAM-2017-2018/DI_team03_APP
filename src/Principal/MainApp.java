/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.Recurso;
import Modelo.RecursoListWrapper;
import Principal.Vista.EditarRecursoController;
import Principal.Vista.PrincipalController;
import Principal.Vista.RootLayoutController;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * Clase principal de la aplicaçao
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Recurso> datosRecursos = FXCollections.observableArrayList();
    /**
     * Método que se inicia al construir la aplicación y que genera el stage principal
     * @param stage Variable de tipo Stage que será la que se lance como principal
     */
    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Solicitud de recursos");

        // set the application icon
        this.primaryStage.getIcons().add(new Image("file:Recursos/MainIcon.png"));

        initRootLayout();

        showPrincipal();
    }
    /**
     * Método que se ejecuta al iniciar la aplicación
     */
    public MainApp() {
        datosRecursos.add(new Recurso(1, "Gimnasio"));
    }
    /**
     * Método que devuelve el array de los datos de Recursos
     * @return Devuelve una variable ObservableList de tipo Recurso
     */
    public ObservableList<Recurso> getDatosRecursos() {
        return datosRecursos;
    }
    /**
     * Método que establece el RootLayout de la aplicación
     */
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Vista/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que lanza la ventana Principal de la aplicación
     */
    public void showPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Vista/Principal.fxml"));
            AnchorPane principal = (AnchorPane) loader.load();

            rootLayout.setCenter(principal);

            PrincipalController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que lanza la ventana Editar Recurso
     * @param recurso Variable de tipo Recurso que indica el recurso a editar
     * @return Devuelve una variable tipo boolean con valor false en caso de dar error
     */
    public boolean mostrarEditarRecurso(Recurso recurso) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Vista/EditarRecurso.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Editar Recurso");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditarRecursoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setRecurso(recurso);

            // Set the dialog icon.
    //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Método que devuelve el Stage primario de la aplicación
     * @return Devuelve una variable tipo Stage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    /**
     * Método principal de la clase
     * @param args Argumentos de inicio de la clase
     */
    public static void main(String[] args) {
        launch(args);
    }
    /**
     * Método que devuelve la ruta del archivo de cargado/guardado
     * @return Devuelve una variable de tipo File en el caso de que se haya ya 
     * establecido la ruta, en caso de que no, devolverá null
     */
    public File getRecursoFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    /**
     * Método que establece la ruta del archivo de cargado/guardado
     * @param file Variable de tipo File
     */
    public void setRecursoFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    }
    /**
     * Método  que lleva a cabo la acción de cargar
     * @param file Variable de tipo File que indicará el archivo del que se carga
     */
    public void loadDatosRecursoFromFile(File file) {
       try {
           JAXBContext context = JAXBContext
                   .newInstance(RecursoListWrapper.class);
           Unmarshaller um = context.createUnmarshaller();

           // Reading XML from the file and unmarshalling.
           RecursoListWrapper wrapper = (RecursoListWrapper) um.unmarshal(file);

           datosRecursos.clear();
           datosRecursos.addAll(wrapper.getRecursos());

           
           setRecursoFilePath(file);

       } catch (Exception e) { // catches ANY exception
   //        Dialogs.create()
   //                .title("Error")
   //                .masthead("Could not load data from file:\n" + file.getPath())
   //                .showException(e);
       }
    }
    /**
     * Método  que lleva a cabo la acción de guardar
     * @param file Variable de tipo File que indicará el archivo donde se guarda
     */
    public void saveDatosRecursoToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(RecursoListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            RecursoListWrapper wrapper = new RecursoListWrapper();
            wrapper.setRecursos(datosRecursos);

            m.marshal(wrapper, file);

            setRecursoFilePath(file);
        } catch (Exception e) { // catches ANY exception
    //                Dialogs.create().title("Error")
    //                .masthead("Could not save data to file:\n" + file.getPath())
    //                .showException(e);
        }
    }
}
