/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.entities;

import java.io.Serializable;
/**
 *
 * @author ALFA-AS3-1A6600
 */
public class Platilloingrediente implements Serializable {

    //private static final long serialVersionUID = 1L;
    private String id;
    private Double gramos;
    private String idIngrediente;
    private String idPlatillo;

    public Platilloingrediente() {
    }

    public Platilloingrediente(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getGramos() {
        return gramos;
    }

    public void setGramos(Double gramos) {
        this.gramos = gramos;
    }

    public String getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(String idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(String idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    @Override
    public String toString() {
        return id;
    }
    
}
