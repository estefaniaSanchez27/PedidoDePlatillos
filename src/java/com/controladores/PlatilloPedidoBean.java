/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.dominio.PlatilloPedido;
import com.dominio.PlatilloPedidoFacade;
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
@Named(value = "platilloPedidoBean")
@ManagedBean
@SessionScoped
public class PlatilloPedidoBean implements Serializable {

    private long id;
    private String idPlatillo;
    private String idPedido;
    private int cantidad;
    
    @EJB
    private PlatilloPedidoFacade platillopedidoFacade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(String idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public List<PlatilloPedido> getPlatilloPedido(){
        return this.platillopedidoFacade.findAll();
    }
    
    public String guarduar(){
        PlatilloPedido pp = new PlatilloPedido();
        pp.setIdPlatillo(idPlatillo);
        pp.setIdPedido(idPedido);
        pp.setCantidad(cantidad);
        this.platillopedidoFacade.create(pp);
        this.id=pp.getId();
        return "index";
    }
    
    /**
     * Creates a new instance of PlatilloPedido
     */
    public PlatilloPedidoBean() {
    }
    
}
