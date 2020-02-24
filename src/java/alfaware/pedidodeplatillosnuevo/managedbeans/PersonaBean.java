/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.PersonaController;
import alfaware.pedidodeplatillosnuevo.entities.Pedido;
import alfaware.pedidodeplatillosnuevo.entities.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@ManagedBean
@Named(value = "personaBean")
@SessionScoped
public class PersonaBean implements Serializable {

    private String id;
    private String nombre;
    private String telefono;
    private String direccion;
    private Collection<Pedido> pedidoCollection;

    private PersonaController personaController;
    Persona per = new Persona();

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String guardar() {
        per.setNombre(nombre);
        per.setTelefono(telefono);
        per.setDireccion(direccion);
        this.id = per.getId();
        this.personaController.add(per);
        return "persona";
    }
    
    public String editar(PersonaBean pb){
        per.setId(id);
        per.setNombre(pb.nombre);
        per.setTelefono(pb.telefono);
        per.setDireccion(pb.direccion);
        this.personaController.modify(per);
        return "persona";
    }
    
    public String eliminar(){
        per.setId(id);
        this.personaController.remove(per);
        return "persona";
    }

    public List<Persona> getPersonas() {
        Map<String, Object> pers = this.personaController.select(per);
        List<Persona> result = new ArrayList(pers.values());
        return result;
    }

    /**
     * Creates a new instance of PersonaBean
     */
    public PersonaBean() {
    }

}
