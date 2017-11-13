/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.*;

/**
 *
 * @author Alejandro
 */
public class Reserva {
    //id_prof, nombre_prof, sala, herramienta, dia, hora_inicio, hora_final, comentario
    private final IntegerProperty id_prof;
    private final StringProperty nombre_prof, sala, herramienta, comentario;
    private final ObjectProperty<LocalDate> hora_inicio, hora_final;
    
    public Reserva() {
        this(0, null, null, null, null, null, null);
    }

    public Reserva(int id_prof, String nombre_prof, String sala, String herramienta, String comentario, LocalDate hora_inicio, LocalDate hora_final) {
        this.id_prof = new SimpleIntegerProperty(id_prof);
        this.nombre_prof = new SimpleStringProperty(nombre_prof);
        this.sala = new SimpleStringProperty(sala);
        this.herramienta = new SimpleStringProperty(herramienta);
        this.comentario = new SimpleStringProperty(comentario);
        this.hora_inicio = new SimpleObjectProperty<LocalDate>(hora_inicio);
        this.hora_final = new SimpleObjectProperty<LocalDate>(hora_final);
    }

    public int getId() {
        return id_prof.get();
    }
    
    public void setId(int id) {
        this.id_prof.set(id);
    }

    public String getNombre() {
        return nombre_prof.get();
    }
    
    public void setNombre(String nombre) {
        this.nombre_prof.set(nombre);
    }

    public String getSala() {
        return sala.get();
    }
    
    public void setSala(String sala) {
        this.sala.set(sala);
    }

    public String getHerramienta() {
        return herramienta.get();
    }
    public void setHerramienta(String herramienta) {
        this.herramienta.set(herramienta);
    }

    public String getComentario() {
        return comentario.get();
    }
    public void setComentario(String comentario) {
        this.comentario.set(comentario);
    }

    public LocalDate getHora_inicio() {
        return hora_inicio.get();
    }
    public void setHoraInicio(LocalDate inicio) {
        this.hora_inicio.set(inicio);
    }

    public LocalDate getHora_final() {
        return hora_final.get();
    }
    
    public void setHoraFinal(LocalDate fin) {
        this.hora_final.set(fin);
    }
    
    
}
