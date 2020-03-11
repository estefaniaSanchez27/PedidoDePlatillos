/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.PlatilloIngredienteController;
import alfaware.pedidodeplatillosnuevo.entities.Ingrediente;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import alfaware.pedidodeplatillosnuevo.entities.Platilloingrediente;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@ManagedBean
@Named(value = "platilloIngredienteBean")
@SessionScoped
public class PlatilloIngredienteBean implements Serializable {

    private String id;
    private String idPlatillo;
    private String idIngrediente;
    private Double gramos;
    private boolean disable;

    private PlatilloIngredienteController platilloingredienteController;
    Platilloingrediente pi = new Platilloingrediente();
    Platillo p = new Platillo();
    Ingrediente i = new Ingrediente();

    @PostConstruct
    public void init() {
        platilloingredienteController = new PlatilloIngredienteController();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Double getGramos() {
        return gramos;
    }

    public void setGramos(Double gramos) {
        this.gramos = gramos;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public void guardar(Platillo pl, Ingrediente i) {
        this.idIngrediente = i.getId();
        this.idPlatillo = pl.getId();
        this.platilloingredienteController.insert(pi, idIngrediente, idPlatillo);

    }

    public String editar(PlatilloIngredienteBean pib) {
        this.platilloingredienteController.update(pi, id, pib.idIngrediente, pib.idPlatillo, pib.gramos);
        return "platilloingrediente";
    }

    /*public String eliminar(){
        this.platilloingredienteController.delete(pi, id);
        return "platilloingrediente";
    }*/
    public List<Platilloingrediente> getPlatilloingredientes() {
        Map<String, Object> plating = this.platilloingredienteController.select(new Platilloingrediente());
        List<Platilloingrediente> result = new ArrayList(plating.values());
        return result;
    }

    /*public List<Ingrediente> obtenerIngredientes(){
        Map<String,Object> ing = this.platilloingredienteController.obtenerIngredientes(p,i,pi,p.getId());
        List<Ingrediente> ingre = new ArrayList(ing.values());
        return ingre;
    }*/
    public String limpiar() {
        this.setIdIngrediente(null);
        this.setIdPlatillo(null);
        this.setGramos(null);
        return "platilloingrediente";
    }

    public void onSelect(Platilloingrediente plaing) {
        this.id = plaing.getId();
        this.idIngrediente = plaing.getIdIngrediente();
        this.idPlatillo = plaing.getIdPlatillo();
        this.gramos = plaing.getGramos();
        this.disable = true;
    }

    public void onDeselect() {
        this.idIngrediente = null;
        this.idPlatillo = null;
        this.gramos = null;
        this.disable = false;
    }

    /**
     * Creates a new instance of PlatilloIngredienteBean
     */
    public PlatilloIngredienteBean() {
        this.disable = false;
    }

}
