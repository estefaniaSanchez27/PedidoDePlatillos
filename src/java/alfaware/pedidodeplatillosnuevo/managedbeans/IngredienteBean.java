/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.IngredienteController;
import alfaware.pedidodeplatillosnuevo.entities.Ingrediente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@ManagedBean
@Named(value = "ingredienteBean")
@SessionScoped
public class IngredienteBean implements Serializable {
    
    private String id;
    private String nombre;
    private Double costoGramo;
    
    private IngredienteController ingredienteController;
    Ingrediente i = new Ingrediente();

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
    
    public String guardar(){
        i.setNombre(nombre);
        i.setCostoGramo(costoGramo);
        this.id=i.getId();
        this.ingredienteController.add(i);
        return "ingrediente";
    }
    
    public String editar(IngredienteBean ib){
        i.setId(id);
        i.setNombre(ib.nombre);
        i.setCostoGramo(ib.costoGramo);
        this.ingredienteController.modify(i);
        return "ingrediente";
    }
    
    public String eliminar(){
        i.setId(id);
        this.ingredienteController.remove(i);
        return "ingrediente";
    }
    
    public List<Ingrediente> getIngredientes(){ 
        Map<String,Object> ing = this.ingredienteController.select(i);
        List<Ingrediente> result = new ArrayList(ing.values());
        return result;
    }
    
    /*public Map<String,Object> getIngredientes(){
        return this.ingredienteController.get(i);
    }*/

    /**
     * Creates a new instance of IngredienteBean
     */
    public IngredienteBean() {
    }
    
}

