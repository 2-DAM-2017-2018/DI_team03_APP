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
 *
 * @author Alejandro Ariza Guerrero y Felipe Pérez Sillero
 */
@XmlRootElement(name = "recursos")
public class RecursoListWrapper {
    private List<Recurso> recursos;

    @XmlElement(name = "person")
    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setPersons(List<Recurso> recursos) {
        this.recursos = this.recursos;
    }
}
