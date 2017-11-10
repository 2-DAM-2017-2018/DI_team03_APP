/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Reserva {
    //id_prof, nombre_prof, sala, herramienta, dia, hora_inicio, hora_final, comentario
    private final int id_prof;
    private final String nombre_prof, sala, herramienta, comentario;
    private final LocalDate hora_inicio, hora_final;
    
    public Reserva() {
        this(0, null, null, null, null, null, null);
    }

    public Reserva(int id_prof, String nombre_prof, String sala, String herramienta, String comentario, LocalDate hora_inicio, LocalDate hora_final) {
        this.id_prof = id_prof;
        this.nombre_prof = nombre_prof;
        this.sala = sala;
        this.herramienta = herramienta;
        this.comentario = comentario;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }
    private void test() {
        
        
    }
    
}
