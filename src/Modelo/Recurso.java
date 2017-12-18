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
 * @author Felipe Pérez Sillero
 */
public class Recurso {
    private StringProperty nombre;
    private IntegerProperty id;
    private static ObservableList<Hora> horario;

    public Recurso() {
        this.id = new SimpleIntegerProperty(0);
        this.nombre = new SimpleStringProperty("");
        horario = FXCollections.observableArrayList();
        horario.add(new Hora("08:00-09:00", "Si"));
        horario.add(new Hora("09:00-10:00", "Si"));
        horario.add(new Hora("10:00-11:00", "Si"));
        horario.add(new Hora("11:30-12:30", "Si"));
        horario.add(new Hora("12:30-13:30", "Si"));
        horario.add(new Hora("13:30-14:30", "Si"));
        horario.add(new Hora("16:00-17:00", "Si"));
    }

    public Recurso(int id, String nombre) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
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
    public void cambiarEstadoHora(StringProperty hora, String estado) {
        boolean salir = false;
        while(!salir) {
            int i = 0;
            if(horario.get(i).getHoraProperty() == hora) {
                horario.get(i).setHora(estado);
            }
            i++;
        }
            
    }

    public void setHora(int pos, Hora hora) {
        this.horario.set(pos, hora);
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