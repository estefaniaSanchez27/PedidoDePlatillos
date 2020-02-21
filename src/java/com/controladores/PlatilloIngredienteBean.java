/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.dominio.PlatilloIngrediente;
import com.dominio.PlatilloIngredienteFacade;
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
@Named(value = "platilloIngredienteBean")
@ManagedBean
@SessionScoped
public class PlatilloIngredienteBean implements Serializable {
    
    private long id;
    private String idPlatillo;
    private String idIngrediente;
    private double gramos;
    
    @EJB
    private PlatilloIngredienteFacade platilloingredienteFacade;

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

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }
    
    public List<PlatilloIngrediente> getPlatilloIngrediente(){
        return this.platilloingredienteFacade.findAll();
    }
    
    public String guarduar(){
        PlatilloIngrediente pi = new PlatilloIngrediente();
        pi.setIdPlatillo(idPlatillo);
        pi.setIdIngrediente(idIngrediente);
        pi.setGramos(gramos);
        this.platilloingredienteFacade.create(pi);
        this.id=pi.getId();
        return "index";
    }

    /**
     * Creates a new instance of PlatilloIngredienteBean
     */
    public PlatilloIngredienteBean() {
    }
    
}
