/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * La clase Fecha indica la fecha en la que se solicita el recurso
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
public class Fecha 
{
    private StringProperty fecha;
    private static ObservableList<Hora> horario;
    
    /**
     * Constructor por parametros
     * @param fecha fecha que se le pasa por parametro
     */
    public Fecha(String fecha) {
        this.fecha = new SimpleStringProperty(fecha);
        horario = FXCollections.observableArrayList();
        horario.add(new Hora("08:00-09:00", "Si"));
        horario.add(new Hora("09:00-10:00", "Si"));
        horario.add(new Hora("10:00-11:00", "Si"));
        horario.add(new Hora("11:30-12:30", "Si"));
        horario.add(new Hora("12:30-13:30", "Si"));
        horario.add(new Hora("13:30-14:30", "Si"));
        horario.add(new Hora("16:00-17:00", "Si"));
    }
    
    /**
     * Devuelve el horario
     * @return devuelbe un ObservableList
     */
    public static ObservableList<Hora> getHorario() {
        return horario;
    }
    
    /**
     * Modifica el horario
     * @param horario horario que se le pasa por parametro
     */
    public void setHorario(ObservableList<Hora> horario) {
        this.horario = horario;
    }
    
    /**
     * Devuelve la hora del horario
     * @param pos posicion del horario que pasamos por parámetro
     * @return devuelve una Hora
     */
    public Hora getHora(int pos) {
        return horario.get(pos);
    }
    
    /**
     * Modifica la hora del horario
     * @param hora hora que le pasamos por parámetro
     * @param pos posicion del horario que pasamos por parámetro
     */
    public void setHora(Hora hora,int pos) {
        this.horario.set(pos, hora);
    }
    
    /**
     * Devuelve la fecha
     * @return devuelve un string
     */
    public String getFecha() {
        return fecha.get();
    }

    /**
     * Modifica la fecha
     * @param fecha fecha que le pasamos por parámetro
     */
    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }
    
    /**
     * Devuelve la fecha
     * @return devuelve un string
     */
    public StringProperty fechaProperty() {
        return fecha;
    }
}
