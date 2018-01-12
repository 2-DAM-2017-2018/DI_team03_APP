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
 *
 * @author Alejandro
 */
public class Recurso {
    private StringProperty nombre;
    private IntegerProperty id;
    private static ObservableList<Fecha> cal;

    public Recurso() {
        this.id = new SimpleIntegerProperty(0);
        this.nombre = new SimpleStringProperty("");
        cal = FXCollections.observableArrayList();
    }

    public Recurso(int id, String nombre) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        cal = FXCollections.observableArrayList();
    }
    
    public void setCal(ObservableList<Fecha> cal) {
        this.cal = cal;
    }
    
    public ObservableList<Fecha> getCal(){
        return this.cal;
    }
    
    public void setFecha(int pos, Fecha fecha) {
        this.cal.set(pos, fecha);
    }
    
    public Fecha getFecha(int pos) {
        return this.cal.get(pos);
    }
    
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
    
    public void addFecha(Fecha f) {
        this.cal.add(f);
    }
    
    public int getId() {
        return id.get();
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    public IntegerProperty idProperty() {
        return id;
    }
    
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    
    public StringProperty nombreProperty() {
        return nombre;
    }
}