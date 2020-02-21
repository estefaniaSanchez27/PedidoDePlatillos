/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.dominio.Platillo;
import com.dominio.PlatilloFacade;
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
@Named(value = "platilloBean")
@SessionScoped
@ManagedBean
public class PlatilloBean implements Serializable {
    
    private long id;
    private String nombre;
    private double costoPrep;
    
    @EJB
    private PlatilloFacade platilloFacade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoPrep() {
        return costoPrep;
    }

    public void setCostoPrep(double costoPrep) {
        this.costoPrep = costoPrep;
    }
    
    public List<Platillo> getPlatillos(){
        return this.platilloFacade.findAll();
    }
    
    public String guarduar(){
        Platillo p = new Platillo();
        p.setNombre(nombre);
        p.setCostoPrep(costoPrep);
        this.platilloFacade.create(p);
        this.id=p.getId();
        return "index";
    }
    /**
     * Creates a new instance of PlatilloBean
     */
    public PlatilloBean() {
    }
    
}
