/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Ingrediente;
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

    /*public List<Ingrediente> get(Ingrediente ingredientes){

    }*/
}
