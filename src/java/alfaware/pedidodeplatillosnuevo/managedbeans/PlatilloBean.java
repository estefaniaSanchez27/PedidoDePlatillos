/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.PlatilloController;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
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
@Named(value = "platilloBean")
@SessionScoped
public class PlatilloBean implements Serializable {

    private String id;
    private String nombre;
    private Double costoPrep;

    private PlatilloController platilloController;
    Platillo pl = new Platillo();

    @PostConstruct
    public void init() {
        platilloController = new PlatilloController();
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

    public Double getCostoPrep() {
        return costoPrep;
    }

    public void setCostoPrep(Double costoPrep) {
        this.costoPrep = costoPrep;
    }

    public String guardar() {
        this.platilloController.insert(pl, nombre, costoPrep);
        return "platillo";
    }

    public String editar(PlatilloBean plb) {
        this.platilloController.update(pl, id, plb.nombre, plb.costoPrep);
        return "platillo";
    }

    public String eliminar() {
        this.platilloController.delete(pl, id);
        return "platillo";
    }

    public List<Platillo> getPlatillos() {
        Map<String, Object> plat = this.platilloController.select(pl);
        List<Platillo> result = new ArrayList(plat.values());
        return result;
    }

    /**
     * Creates a new instance of PlatilloBean
     */
    public PlatilloBean() {
    }

}
