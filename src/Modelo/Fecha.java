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
 *
 * @author Felipe Pérez Sillero
 */
public class Fecha 
{
    private StringProperty fecha;
    private static ObservableList<Hora> horario;
    
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
    
    public static ObservableList<Hora> getHorario() {
        return horario;
    }
    
    public void setHorario(ObservableList<Hora> horario) {
        this.horario = horario;
    }
    
    public Hora getHora(int pos) {
        return horario.get(pos);
    }
    
    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }
    
    public StringProperty fechaProperty() {
        return fecha;
    }
}
