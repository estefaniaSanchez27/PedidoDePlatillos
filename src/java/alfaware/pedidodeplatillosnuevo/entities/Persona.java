/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class Persona implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String id;
    private String nombre;
    private String telefono;
    private String direccion;

    public Persona() {
    }

    public Persona(String id) {
        this.id=id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /*public PedidoPersona getPedidopersona() {
        return pedidopersona;
    }

    public void setPedidopersona(PedidoPersona pedidopersona) {
        this.pedidopersona = pedidopersona;
    }*/
    
    
    
    @Override
    public String toString() {
        return id;
    }

}
