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

public class Pedido implements Serializable {

    //private static final long serialVersionUID = 1L;
    //private PedidoPersona pedidopersona;
    private String id;
    private String fecha;
    private String idPersona;
    //Persona personas = new Persona();
    

    public Pedido() {
    }

    /*public Pedido(String id) {
        this.id=id;
    }*/
    
    public Pedido(String id){
        this.id=id;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    /*public Persona getPersonas() {
        return personas;
    }

    public void setPersonas(Persona personas) {
        this.personas = personas;
    }*/

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
