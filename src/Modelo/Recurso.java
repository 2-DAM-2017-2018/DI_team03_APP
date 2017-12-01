/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
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
    private ArrayList<Hora> horario;

    public Recurso() {
        this.id = new SimpleIntegerProperty(0);
        this.nombre = new SimpleStringProperty("");
        horario.add(new Hora("Primera", "Si"));
        horario.add(new Hora("Segunda", "Si"));
        horario.add(new Hora("Tercera", "Si"));
        horario.add(new Hora("Cuarta", "Si"));
        horario.add(new Hora("Quinta", "Si"));
        horario.add(new Hora("Sexta", "Si"));
        horario.add(new Hora("Tarde", "Si"));
    }

    public Recurso(int id, String nombre) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        horario.add(new Hora("Primera", "Si"));
        horario.add(new Hora("Segunda", "Si"));
        horario.add(new Hora("Tercera", "Si"));
        horario.add(new Hora("Cuarta", "Si"));
        horario.add(new Hora("Quinta", "Si"));
        horario.add(new Hora("Sexta", "Si"));
        horario.add(new Hora("Tarde", "Si"));
    }

    public ArrayList<Hora> getHorario() {
        return horario;
    }
    
    public void setHorario(ArrayList<Hora> horario) {
        this.horario = horario;
    }
    
    public Hora getHora(int pos) {
        return horario.get(pos);
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