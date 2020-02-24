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
    private Platillo idPlatillo;
    private Ingrediente idIngrediente;
    private Double gramos;

    private PlatilloIngredienteController platilloingredienteController;
    Platilloingrediente pi = new Platilloingrediente();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Platillo getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Platillo idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public Ingrediente getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Ingrediente idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Double getGramos() {
        return gramos;
    }

    public void setGramos(Double gramos) {
        this.gramos = gramos;
    }

    public String guardar() {
        pi.setIdPlatillo(idPlatillo);
        pi.setIdIngrediente(idIngrediente);
        pi.setGramos(gramos);
        this.id = pi.getId();
        this.platilloingredienteController.add(pi);
        return "platilloingrediente";
    }

    public List<Platilloingrediente> getPlatilloingredientes() {
        Map<String, Object> plating = this.platilloingredienteController.get(pi);
        List<Platilloingrediente> result = new ArrayList(plating.values());
        return result;
    }

    /**
     * Creates a new instance of PlatilloIngredienteBean
     */
    public PlatilloIngredienteBean() {
    }

}

