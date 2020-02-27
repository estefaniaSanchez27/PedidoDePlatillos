/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import java.util.Map;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class PlatilloController extends ControllerUtils {

    public PlatilloController() {
        super();
    }

    public static Map<String, Object> select(Platillo pla) {
        Map<String, Object> map = get(pla);
        return map;
    }
    
    public void insert(Platillo pla,String nombre,Double costoPrep){
        pla.setNombre(nombre);
        pla.setCostoPrep(costoPrep);
        pla.getId();
        add(pla);
    }
    
    public void update(Platillo pla,String id,String nombre,Double costoPrep){
        pla.setId(id);
        pla.setNombre(nombre);
        pla.setCostoPrep(costoPrep);
        modify(pla);
    }
    
    public void delete(Platillo pla,String id){
        pla.setId(id);
        remove(pla);
    }
}


