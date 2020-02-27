/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Pedido;
import alfaware.pedidodeplatillosnuevo.entities.Persona;
import java.util.Map;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class PedidoController extends ControllerUtils {

    public PedidoController() {
        super();
    }

    public static Map<String, Object> select(Pedido ped) {
        Map<String, Object> map = get(ped);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Pedido pedido = ((Pedido) entry.getValue());
            Map<String, Object> m = PersonaController.select(new Persona(pedido.getIdPersona()));
            if (!m.isEmpty()) {
                pedido.setIdPersona(String.valueOf(m.get(pedido.getIdPersona())));
            }
        }

        return map;
    }

    public void insert(Pedido ped, String idPersona, String fecha) {
        ped.setIdPersona(idPersona);
        ped.setFecha(fecha);
        ped.getId();
        add(ped);
    }

    public void update(Pedido ped, String id, String idPersona, String fecha) {
        ped.setId(id);
        ped.setIdPersona(idPersona);
        ped.setFecha(fecha);
        modify(ped);
    }

    public void delete(Pedido ped, String id) {
        ped.setId(id);
        remove(ped);
    }

}
