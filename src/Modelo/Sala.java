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
public class Sala extends Recurso {
    private IntegerProperty idSala;

    public Sala() {
        this.idSala = null;
    }

    public Sala(String nombre, int idSala) {
        super(nombre);
        this.idSala = new SimpleIntegerProperty(idSala);
    }

    public int getIdSala() {
        return idSala.get();
    }

    public void setIdSala(int idSala) {
        this.idSala.set(idSala);
    }
    
    public IntegerProperty idSala() {
        return idSala;
    }
    
}
