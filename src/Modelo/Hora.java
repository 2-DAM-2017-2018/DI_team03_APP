/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Felipe Pérez Sillero
 */
public class Hora
{
    private StringProperty hora;
    private StringProperty libre;
    
    public Hora(String hora, String libre) {
        this.hora = new SimpleStringProperty(hora);
        this.libre = new SimpleStringProperty(libre);
    }

    public String getHora() {
        return hora.get();
    }
    public StringProperty getHoraProperty() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }

    public String getLibre() {
        return libre.get();
    }
    public StringProperty getLibreProperty() {
        return libre;
    }

    public void setLibre(StringProperty libre) {
        this.libre = libre;
    }
     
}
