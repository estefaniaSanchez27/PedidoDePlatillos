/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Ingrediente;
import alfaware.pedidodeplatillosnuevo.entities.Platilloingrediente;
import alfaware.pedidodeplatillosnuevo.managedbeans.IngredienteBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class IngredienteController extends ControllerUtils {

    public IngredienteController() {
        super();
    }

    public static Map<String, Object> select(Ingrediente ing) {
        Map<String, Object> map = get(ing);
        return map;
    }

    public void insert(Ingrediente ing, String nombre, Double costoGramo) {
        ing.setNombre(nombre);
        ing.setCostoGramo(costoGramo);
        ing.getId();
        add(ing);

    }

    public void update(Ingrediente ing, String id, String nombre, Double costogramo) {
        ing.setId(id);
        ing.setNombre(nombre);
        ing.setCostoGramo(costogramo);
        modify(ing);
    }

    public void delete(Ingrediente ing, String id) {
        ing.setId(id);
        remove(ing);
    }


    /*public List<Ingrediente> get(Ingrediente ingredientes){

    }*/
}
