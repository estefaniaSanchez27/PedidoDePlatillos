/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.entities;

import java.io.Serializable;


/**
 *
 * @author ALFA-AS3-1A6600
 */
public class Ingrediente implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private Double costoGramo;

    public Ingrediente() {
    }

    public Ingrediente(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCostoGramo() {
        return costoGramo;
    }

    public void setCostoGramo(Double costoGramo) {
        this.costoGramo = costoGramo;
    }

    @Override
    public String toString() {
        return id;
    }
    
}
