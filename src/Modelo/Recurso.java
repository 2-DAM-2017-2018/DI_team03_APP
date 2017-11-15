/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Felipe Pérez Sillero
 */
public class Recurso {
    private StringProperty nombre;

    public Recurso() {
        this.nombre = null;
    }

    public Recurso(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }
    
    public StringProperty nombre() {
        return nombre;
    }
}