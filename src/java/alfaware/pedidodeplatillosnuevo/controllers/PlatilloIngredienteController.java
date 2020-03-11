/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Ingrediente;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import alfaware.pedidodeplatillosnuevo.entities.Platilloingrediente;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class PlatilloIngredienteController extends ControllerUtils {

    public PlatilloIngredienteController() {
        super();
    }

    public static Map<String, Object> select(Platilloingrediente plaing) {
        Map<String, Object> map = get(plaing);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Platilloingrediente platilloing = ((Platilloingrediente) entry.getValue());
            Map<String, Object> i = IngredienteController.select(new Ingrediente(platilloing.getIdIngrediente()));
            Map<String, Object> p = PlatilloController.select(new Platillo(platilloing.getIdPlatillo()));
            if (!i.isEmpty() && !p.isEmpty()) {
                platilloing.setIdIngrediente(String.valueOf(i.get(platilloing.getIdIngrediente())));
                platilloing.setIdPlatillo(String.valueOf(p.get(platilloing.getIdPlatillo())));
            }
        }

        return map;
    }

    public void insert(Platilloingrediente plaing, String idIngrediente, String idPlatillo) {
        plaing.setIdIngrediente(idIngrediente);
        plaing.setIdPlatillo(idPlatillo);
        plaing.getId();
        add(plaing);
    }

    public void update(Platilloingrediente plaing, String id, String idIngrediente, String idPlatillo, Double gramos) {
        plaing.setId(id);
        plaing.setIdIngrediente(idIngrediente);
        plaing.setIdPlatillo(idPlatillo);
        plaing.setGramos(gramos);
        modify(plaing);
    }

    public void delete(Ingrediente i, String idPlatillo, Platilloingrediente plaing) {
        String idIngrediente = i.getId();
        Map<String, Object> platillosingredientes = select(plaing);
        for (Map.Entry<String, Object> entry : platillosingredientes.entrySet()) {
            Platilloingrediente platilloing = ((Platilloingrediente) entry.getValue());
            if (idPlatillo == null ? platilloing.getIdPlatillo() == null : idPlatillo.equals(platilloing.getIdPlatillo())) {
                if (idIngrediente == null ? platilloing.getIdIngrediente() == null : idIngrediente.equals(platilloing.getIdIngrediente())) {
                    String id = platilloing.getId();
                    plaing.setId(id);
                    remove(plaing);
                }
            }
        }
    }

    public static Map<String, Object> obtenerIngredientesdePlatillo(Platillo pla, Ingrediente ing, Platilloingrediente plaing, String id) {
        pla.setId(id);
        Map<String, Object> platillosingredientes = select(plaing);
        Map<String, Object> ingredientes = get(ing);
        Map<String, Object> map = new HashMap<>();
        for (Map.Entry<String, Object> entry : platillosingredientes.entrySet()) {
            Platilloingrediente platilloing = ((Platilloingrediente) entry.getValue());
            if (id == null ? platilloing.getIdPlatillo() == null : id.equals(platilloing.getIdPlatillo())) {
                if (ingredientes.containsKey(platilloing.getIdIngrediente())) {
                    Map<String, Object> i = IngredienteController.select(new Ingrediente(platilloing.getIdIngrediente()));
                    map.putAll(i);
                }
            }
        }
        return map;
    }

    //public static Map<String,Object> obtenerIngrediente(Ingrediente i){
    //Map<String,Object> ingredientes = get(i);
    //return ingredientes;
    //}
}
