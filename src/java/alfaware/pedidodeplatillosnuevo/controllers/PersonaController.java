/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.controllers;

import alfaware.alfawareutils.utils.ControllerUtils;
import alfaware.pedidodeplatillosnuevo.entities.Persona;
import java.util.Map;

/**
 *
 * @author ALFA-AS3-1A6600
 */
public class PersonaController extends ControllerUtils {

    public PersonaController() {
        super();
    }

    public static Map<String, Object> select(Persona per) {
        Map<String, Object> map = get(per);
        return map;
    }

    public void insert(Persona per, String nombre, String telefono, String direccion) {
        per.setNombre(nombre);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        per.getId();
        add(per);
    }

    public void update(Persona per, String id, String nombre, String telefono, String direccion) {
        per.setId(id);
        per.setNombre(nombre);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        modify(per);
    }

    public void delete(Persona per, String id) {
        per.setId(id);
        remove(per);
    }
}
