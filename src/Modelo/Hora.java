/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * La clase Hora indica una hora que se incluye al horario
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
public class Hora
{
    private StringProperty hora;
    private StringProperty libre;
    
    /**
     * Constructor por parámetros
     * @param hora hora que le pasamos por parámetro
     * @param libre estado que le pasamos por parámetro
     */
    public Hora(String hora, String libre) {
        this.hora = new SimpleStringProperty(hora);
        this.libre = new SimpleStringProperty(libre);
    }

    /**
     * Devuelve la hora
     * @return devuelve un string
     */
    public String getHora() {
        return hora.get();
    }
    
    /**
     * Devuelve la hora en formato StringProperty
     * @return devuelve un StringProperty
     */
    public StringProperty getHoraProperty() {
        return hora;
    }

    /**
     * Modifica la hora
     * @param hora hora que le pasamos por parámetro
     */
    public void setHora(String hora) {
        this.hora.set(hora);
    }

    /**
     * Devuelve el estado
     * @return devuelve un string
     */
    public String getLibre() {
        return libre.get();
    }
    
    /**
     * Devuelve el estado en formato StringProperty
     * @return devuelve un StringProperty
     */
    public StringProperty getLibreProperty() {
        return libre;
    }

    /**
     * Modifica el estado
     * @param libre estado que le pasamos por parámetro
     */
    public void setLibre(StringProperty libre) {
        this.libre = libre;
    }
     
}
