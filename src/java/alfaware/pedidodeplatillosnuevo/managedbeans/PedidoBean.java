/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.PedidoController;
import alfaware.pedidodeplatillosnuevo.entities.Pedido;
import alfaware.pedidodeplatillosnuevo.entities.Persona;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@ManagedBean
@Named(value = "pedidoBean")
@SessionScoped
public class PedidoBean implements Serializable {

    private String id;
    private String idPersona;
    private String fecha;
    
    //private static ArrayList<Persona> persona = new ArrayList<>();

    private PedidoController pedidoController;
    //private LinkedList<Persona> idPersonas = new LinkedList<Persona>();
    Pedido pe = new Pedido();
    
    @PostConstruct
    public void init() {
        pedidoController = new PedidoController();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String guardar() {
        this.pedidoController.insert(pe, idPersona, fecha);
        return "pedido";
    }
    
    public String editar(PedidoBean pdb){
        this.pedidoController.update(pe, id, pdb.idPersona, pdb.fecha);
        return "pedido";
    }
    
    public String eliminar(){
        this.pedidoController.delete(pe, id);
        return "pedido";
    }

    public List<Pedido> getPedidos() {
        Map<String, Object> ped = this.pedidoController.select(pe);
        List<Pedido> result = new ArrayList(ped.values());
        return result;
    }

    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {
        
        //personas = new LinkedList<PersonaBean>()
        
        
    }

}
