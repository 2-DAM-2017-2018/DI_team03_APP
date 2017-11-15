/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Alejandro
 */
public class Herramienta extends Recurso {
    private final IntegerProperty idHerramienta;

    public Herramienta() {
        this.idHerramienta = null;
    }

    public Herramienta(String nombre, int idHerramienta) {
        super(nombre);
        this.idHerramienta = new SimpleIntegerProperty(idHerramienta);
    }

    public int getIdHerramienta() {
        return idHerramienta.get();
    }

    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta.set(idHerramienta);
    }
    
    public IntegerProperty idHerramienta() {
        return idHerramienta;
    }
    
    
}
