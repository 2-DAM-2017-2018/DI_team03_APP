/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase que permite crear la lista de recursos
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
@XmlRootElement(name = "recursos")
public class RecursoListWrapper {
    private List<Recurso> recursos;
    /**
     * Método que devuelve la lista de recursos
     * @return Devuelve una variable List de tipo Recurso
     */
    @XmlElement(name = "person")
    public List<Recurso> getRecursos() {
        return recursos;
    }
    /**
     * Método que permite establecer la lista de recursos a la que se pasa por
     * parámetro
     * @param recursos Variable List de tipo Recurso que establecerá el valor
     * de la lista de recursos de la clase
     */
    public void setRecursos(List<Recurso> recursos) {
        this.recursos = this.recursos;
    }
}
