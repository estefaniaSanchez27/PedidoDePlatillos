/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Pedido;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import alfaware.pedidodeplatillosnuevo.entities.Platillopedido;
import java.util.Map;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class PlatilloPedidoController extends ControllerUtils {

    public PlatilloPedidoController() {
        super();
    }

    public static Map<String, Object> select(Platillopedido plaped) {
        Map<String, Object> map = get(plaped);

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Platillopedido platilloped = ((Platillopedido) entry.getValue());
            Map<String, Object> pe = PedidoController.select(new Pedido(platilloped.getIdPedido()));
            Map<String, Object> pl = PlatilloController.select(new Platillo(platilloped.getIdPlatillo()));
            if (!pe.isEmpty() && !pl.isEmpty()) {
                platilloped.setIdPedido(String.valueOf(pe.get(platilloped.getIdPedido())));
                platilloped.setIdPlatillo(String.valueOf(pl.get(platilloped.getIdPlatillo())));
            }
        }

        return map;
    }
    
    public void insert(Platillopedido plaped,String idPlatillo,String idPedido,int cantidad){
        plaped.setIdPlatillo(idPlatillo);
        plaped.setIdPedido(idPedido);
        plaped.setCantidad(cantidad);
        plaped.getId();
        add(plaped);
    }
    
    public void update(Platillopedido plaped,String id,String idPlatillo,String idPedido,int cantidad){
        plaped.setId(id);
        plaped.setIdPlatillo(idPlatillo);
        plaped.setIdPedido(idPedido);
        plaped.setCantidad(cantidad);
        modify(plaped);
    }
    
    public void delete(Platillopedido plaped,String id){
        plaped.setId(id);
        remove(plaped);
    }

}
