/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.StringProperty;

/**
 *
 * @author Felipe Pérez Sillero
 */
public class Hora 
{
    private StringProperty hora;
    private StringProperty libre;
    
    public Hora(StringProperty hora, StringProperty libre) {
        this.hora = hora;
        this.libre = libre;
    }

    public StringProperty getHora() {
        return hora;
    }

    public void setHora(StringProperty hora) {
        this.hora = hora;
    }

    public StringProperty getLibre() {
        return libre;
    }

    public void setLibre(StringProperty libre) {
        this.libre = libre;
    }
    
}
