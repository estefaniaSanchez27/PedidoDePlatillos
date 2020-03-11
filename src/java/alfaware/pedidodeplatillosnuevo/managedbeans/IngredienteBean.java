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
import java.sql.Array;
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
    private boolean disable;

    //private Ingrediente i;
    private IngredienteController ingredienteController;

    Ingrediente i = new Ingrediente();

    //Map<String, Object> ings = ingredienteController.select(i);
    private List<Ingrediente> result;

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

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    /*public String guardar() {
        ingredienteController.insert(i, nombre, costoGramo);
        return "ingrediente";

    }

    public String editar(IngredienteBean ib) {
        //Ingrediente iu = new Ingrediente();
        ingredienteController.update(i, id, ib.nombre, ib.costoGramo);
        //Map<String,Object> map = ingredienteController.select(iu);
        //result = new ArrayList(map.values());
        this.getIngredientes();
        return "ingrediente";
    }*/
    public String guarduar(IngredienteBean ib) {
        if (this.disable == true) {
            this.ingredienteController.update(i, id, ib.nombre, ib.costoGramo);
            return "ingrediente";
        } else {
            this.ingredienteController.insert(i, nombre, costoGramo);
            return "ingrediente";
        }
    }

    public String eliminar() {
        ingredienteController.delete(i, id);
        return "ingrediente";
    }

    public String limpiar() {
        this.setNombre(null);
        this.setCostoGramo(null);
        this.disable = false;
        return "ingrediente";
    }

    public void onSelect(Ingrediente ing) {
        this.id = ing.getId();
        this.nombre = ing.getNombre();
        this.costoGramo = ing.getCostoGramo();
        this.disable = true;
    }

    public void onDeselect() {
        this.nombre = null;
        this.costoGramo = null;
        this.disable = false;
    }

    public List<Ingrediente> getIngredientes() {
        Map<String, Object> ings = ingredienteController.select(new Ingrediente());
        result = new ArrayList(ings.values());
        return result;
    }

    /*public Map<String,Object> getIngredientes(){
        return this.ingredienteController.get(i);
    }*/
    /**
     * Creates a new instance of IngredienteBean
     */
    public IngredienteBean() {
        this.disable = false;
    }

}
