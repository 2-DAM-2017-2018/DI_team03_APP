/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase que almacena la información de un recurso a reservar
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
public class Recurso {
    private StringProperty nombre;
    private IntegerProperty id;
    private static ObservableList<Fecha> cal;
    /**
     * Constructor por defecto de la clase, inicializa las variables con valores vacios
     */
    public Recurso() {
        this.id = new SimpleIntegerProperty(0);
        this.nombre = new SimpleStringProperty("");
        cal = FXCollections.observableArrayList();
    }
    /**
     * Constructor por parámetros que inicializa las variables a los parámetros 
     * que se han pasado
     * @param id Variable de tipo int que define el identificador del recurso
     * @param nombre Variable de tipo String que define el nombre del recurso
     */
    public Recurso(int id, String nombre) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        cal = FXCollections.observableArrayList();
    }
    /**
     * Método que permite establecer el array de fechas al array 
     * que se pasa por parámetro
     * @param cal ObservableList de tipo Fecha que se usará para establecer el 
     * valor del array de la clase
     */
    public void setCal(ObservableList<Fecha> cal) {
        this.cal = cal;
    }
    /**
     * Método que devuelve el array de fechas
     * @return Devuelve una variable ObservableList de tipo Fecha
     */
    public ObservableList<Fecha> getCal(){
        return this.cal;
    }
    /**
     * Método que permite establer una fecha concreta del array de fechas
     * pasandole la posición y la variable tipo Fecha por parámetro
     * @param pos Variable tipo int que indica la posición en el array 
     * @param fecha Variable tipo Fecha que sustituiráa esa posicin
     */
    public void setFecha(int pos, Fecha fecha) {
        this.cal.set(pos, fecha);
    }
    /**
     * Método que devuelve una fecha en una posición concreta del array de fechas
     * @param pos Variable de tipo int que indica la posición en el array
     * @return Devuelve una variable tipo Fecha
     */
    public Fecha getFecha(int pos) {
        return this.cal.get(pos);
    }
    /**
     * Método que comprueba si una fecha que se pasa por parámetro existe en el
     * array de fechas
     * @param fecha Variable tipo Fecha que representa la fecha que se comprueba
     * @return Devuelve un entero con el valor de la posición en el array,
     * en caso de no existir se devolverá -1
     */
    public int comprobarFecha(Fecha fecha) {
        int existe = -1;
        for(int i = 0; i < cal.size(); i++) {
            String fechaSeleccionada = fecha.getFecha();
            String fechaComprobar = cal.get(i).getFecha();
            if(fechaSeleccionada.equals(fechaComprobar)) {
                existe = i;
            }
        }
        return existe;
    }
    /**
     * Método que comprueba si una fecha que se pasa por parámetro existe en el
     * array de fechas
     * @param fecha Variable de tipo String que representa la fecha que se comprueba
     * @return Devuelve un entero con el valor de la posición en el array,
     * en caso de no existir se devolverá -1
     */
    public int comprobarFecha(String fecha) {
        int existe = -1;
        for(int i = 0; i < cal.size(); i++) {
            String fechaSeleccionada = fecha;
            String fechaComprobar = cal.get(i).getFecha();
            if(fechaSeleccionada.equals(fechaComprobar)) {
                existe = i;
            }
        }
        return existe;
    }
    /**
     * Método que añade una fecha que se pasa por parámetro al array de fechas
     * @param f Variable de tipo Fecha que se añadirá al array de fechas
     */
    public void addFecha(Fecha f) {
        this.cal.add(f);
    }
    /**
     * Método que devuelve el id del recurso
     * @return Devuelve una variable de tipo int 
     */
    public int getId() {
        return id.get();
    }
    /**
     * Método que permite establecer el valor del identificador pasandole una 
     * variable por parámetro
     * @param id Variable de tipo int que establecerá el id del recurso
     */
    public void setId(int id) {
        this.id.set(id);
    }
    /**
     * Método que devuelve el id del recurso en forma de IntegerProperty
     * @return Devuelve una variable de tipo IntegerProperty
     */
    public IntegerProperty idProperty() {
        return id;
    }
    /**
     * Método que devuelve el nombre del recurso
     * @return Devuelve una variable de tipo String
     */
    public String getNombre() {
        return nombre.get();
    }
    /**
     * Método que permite establecer el valor del nombre pasandole una variable
     * por parámetro
     * @param nombre Variable de tipo String que establecerá el nombre del recurso
     */
    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    /**
     * Método que devuelve el id del recurso en forma de StringProperty
     * @return Devuelve una variable de tipo StringProperty
     */
    public StringProperty nombreProperty() {
        return nombre;
    }
}