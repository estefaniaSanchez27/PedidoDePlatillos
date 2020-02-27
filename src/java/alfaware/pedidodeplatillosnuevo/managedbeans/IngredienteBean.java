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
import javax.annotation.PostConstruct;
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
    //private Ingrediente i;
    private IngredienteController ingredienteController;

    Ingrediente i = new Ingrediente();
    @PostConstruct
    public void init() {
        ingredienteController = new IngredienteController();
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

    public String guardar() {
        this.ingredienteController.insert(i, nombre, costoGramo);
        return "ingrediente";

    }

    public String editar(IngredienteBean ib) {
        this.ingredienteController.update(i, id, ib.nombre, ib.costoGramo);
        return "ingrediente";
    }

    public String eliminar() {
        this.ingredienteController.delete(i, id);
        return "ingrediente";
    }

    public List<Ingrediente> getIngredientes() {
        Map<String, Object> ing = this.ingredienteController.select(i);
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
