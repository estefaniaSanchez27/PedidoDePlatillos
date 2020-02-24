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
}

