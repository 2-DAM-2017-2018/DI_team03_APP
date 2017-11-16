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

/**
 *
 * @author Felipe Pérez Sillero
 */
public class Recurso {
    private StringProperty nombre;
    private IntegerProperty id;

    public Recurso() {
        this.nombre = null;
        this.id = null;
    }

    public Recurso(int id, String nombre) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
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