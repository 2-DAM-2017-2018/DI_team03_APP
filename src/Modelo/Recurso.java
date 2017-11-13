/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Felipe Pérez Sillero
 */
public class Recurso 
{
    private String nombre;
    private boolean sala;

    public Recurso() {
        this.nombre = null;
        this.sala = true;
    }

    public Recurso(String nombre, boolean sala) {
        this.nombre = nombre;
        this.sala = sala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSala() {
        return sala;
    }

    public void setSala(boolean sala) {
        this.sala = sala;
    }
    
    
}
