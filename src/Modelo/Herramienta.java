/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alejandro
 */
public class Herramienta extends Recurso {
    private int idHerramienta;

    public Herramienta() {
        this.idHerramienta = 0;
    }

    public Herramienta(String nombre, int idHerramienta) {
        super(nombre);
        this.idHerramienta = idHerramienta;
    }

    public int getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta = idHerramienta;
    }
    
    
}
