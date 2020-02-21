/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.dominio.Pedido;
import com.dominio.PedidoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@Named(value = "pedidoBean")
@ManagedBean
@SessionScoped
public class PedidoBean implements Serializable {
    
    private long id;
    private String idPersona;
    private String fecha;
    
    @EJB
    private PedidoFacade pedidoFacade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public List<Pedido> getPedidos(){
        return this.pedidoFacade.findAll();
    }
    
    public String guarduar(){
        Pedido pd = new Pedido();
        pd.setIdPersona(idPersona);
        pd.setFecha(fecha);
        this.pedidoFacade.create(pd);
        this.id=pd.getId();
        return "index";
    }

    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
    }
    
}
