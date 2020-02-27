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

    public void insert(Platilloingrediente plaing, String idIngrediente, String idPlatillo, Double gramos) {
        plaing.setIdIngrediente(idIngrediente);
        plaing.setIdPlatillo(idPlatillo);
        plaing.setGramos(gramos);
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

    public void delete(Platilloingrediente plaing, String id) {
        plaing.setId(id);
        remove(plaing);
    }

}
