/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.PedidoController;
import alfaware.pedidodeplatillosnuevo.controllers.PlatilloController;
import alfaware.pedidodeplatillosnuevo.controllers.PlatilloPedidoController;
import alfaware.pedidodeplatillosnuevo.entities.Pedido;
import alfaware.pedidodeplatillosnuevo.entities.Persona;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import alfaware.pedidodeplatillosnuevo.entities.Platillopedido;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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
    private boolean disable;

    //private static ArrayList<Persona> persona = new ArrayList<>();
    private PedidoController pedidoController;
    private PlatilloPedidoController platillopedidoController;
    private PlatilloController platilloController;
    //private LinkedList<Persona> idPersonas = new LinkedList<Persona>();
    Pedido pe = new Pedido();
    Platillo pla = new Platillo();
    PlatilloBean peb = new PlatilloBean();
    Platillopedido plaped = new Platillopedido();
    private List<Platillo> platillos;
    private List<Platillo> plaAgregados;
    private List<Platillo> plaDispo;

    @PostConstruct
    public void init() {
        pedidoController = new PedidoController();
        platillopedidoController = new PlatilloPedidoController();
        platilloController = new PlatilloController();
        platillos = new ArrayList();
        plaAgregados = new ArrayList();
        plaDispo = new ArrayList();
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

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public List<Platillo> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<Platillo> platillos) {
        this.platillos = platillos;
    }

    public List<Platillo> getPlaAgregados() {
        return plaAgregados;
    }

    public void setPlaAgregados(List<Platillo> plaAgregados) {
        this.plaAgregados = plaAgregados;
    }

    public List<Platillo> getPlaDispo() {
        return plaDispo;
    }

    public void setPlaDispo(List<Platillo> plaDispo) {
        this.plaDispo = plaDispo;
    }


    /*public String guardar() {
        this.pedidoController.insert(pe, idPersona, fecha);
        return "pedido";
    }*/
    public String guarduar(PedidoBean pdb) {
        if (this.disable == true) {
            this.pedidoController.update(pe, id, pdb.idPersona, pdb.fecha);
            return "pedido";
        } else {
            this.pedidoController.insert(pe, idPersona, fecha);
            return "pedido";
        }
    }

    /*public String editar(PedidoBean pdb){
        this.pedidoController.update(pe, id, pdb.idPersona, pdb.fecha);
        return "pedido";
    }*/
    public String eliminar() {
        this.pedidoController.delete(pe, id);
        return "pedido";
    }

    public List<Pedido> getPedidos() {
        Map<String, Object> ped = this.pedidoController.select(new Pedido());
        List<Pedido> result = new ArrayList(ped.values());
        return result;
    }

    public List<Platillo> obtenerPlatillosPedido(Pedido p, String id) {
        Map<String, Object> plati = this.platillopedidoController.obtenerPlatillosPedido(p, pla, plaped, id);
        List<Platillo> plat = new ArrayList(plati.values());
        return plat;
    }

    public List<Platillo> obtenerPlatillos() {
        Map<String, Object> plati = this.platilloController.select(new Platillo());
        List<Platillo> listpla = new ArrayList(plati.values());
        return listpla;
    }

    public String limpiar() {
        this.setIdPersona(null);
        this.setFecha(null);
        this.disable = false;
        return "pedido";
    }

    public void onSelect(Pedido ped) {
        this.id = ped.getId();
        this.idPersona = ped.getIdPersona();
        this.fecha = ped.getFecha();
        this.disable = true;
        this.plaAgregados = this.obtenerPlatillosPedido(pe, ped.getId());
        this.platillos = this.obtenerPlatillos();
        this.plaDispo = this.diferencia(plaAgregados, platillos);

    }

    public void onDeselect() {
        this.idPersona = null;
        this.fecha = null;
        this.disable = false;
    }

    public void insertarPlatilloaPedido(Platillo p) {
        this.platillopedidoController.insert(new Platillopedido(), p.getId(), id, 0);
        this.plaAgregados = this.obtenerPlatillosPedido(pe, id);
        Platillo plaBus = p;
        int posicion = this.plaDispo.indexOf(plaBus);
        this.plaDispo.remove(posicion);
    }

    public void eliminarPlatilloaPedido(Platillo p) {
        this.platillopedidoController.delete(p, id, new Platillopedido());
        this.plaAgregados = this.obtenerPlatillosPedido(pe, id);
        this.plaDispo.add(p);
    }

    public List<Platillo> diferencia(List<Platillo> list1, List<Platillo> list2) {
        Iterator<Platillo> i;
        Iterator<Platillo> j;

        List<Platillo> l2 = new ArrayList<>();
        l2.addAll(list2);
        Platillo p1, p2;
        i = list1.iterator();
        j = l2.iterator();

        while (i.hasNext()) {
            p1 = i.next();
            while (j.hasNext()) {
                p2 = j.next();
                if (p1.getId().equals(p2.getId())) {
                    list2.remove(p2);
                }
            }
            j = l2.iterator();
        }

        return list2;

    }

    /**
     * Creates a new instance of PedidoBean
     */
    public PedidoBean() {

        //personas = new LinkedList<PersonaBean>()
        this.disable = false;

    }

}
