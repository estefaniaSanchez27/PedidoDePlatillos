/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.dominio.Ingrediente;
import com.dominio.IngredienteFacade;
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
@Named(value = "ingredienteBean")
@ManagedBean
@SessionScoped
public class IngredienteBean implements Serializable {
    
    private long id;
    private String nombre;
    private double costoGramo;
    
    @EJB
    private IngredienteFacade ingredienteFacade;

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

    public double getCostoGramo() {
        return costoGramo;
    }

    public void setCostoGramo(double costoGramo) {
        this.costoGramo = costoGramo;
    }

    public List<Ingrediente> getIngredientes(){
        return this.ingredienteFacade.findAll();
    }
    
    public String guarduar(){
        Ingrediente i = new Ingrediente();
        i.setNombre(nombre);
        i.setCostoGramo(costoGramo);
        this.ingredienteFacade.create(i);
        this.id=i.getId();
        return "index";
    }
    /**
     * Creates a new instance of IngredienteBean
     */
    public IngredienteBean() {
        
    }
    
}
