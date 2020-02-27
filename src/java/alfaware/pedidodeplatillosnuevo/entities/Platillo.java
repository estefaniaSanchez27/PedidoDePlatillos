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
public class Platillo implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String id;
    private Double costoPrep;
    private String nombre;

    public Platillo() {
    }

    public Platillo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getCostoPrep() {
        return costoPrep;
    }

    public void setCostoPrep(Double costoPrep) {
        this.costoPrep = costoPrep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return id;
    }
    
}
