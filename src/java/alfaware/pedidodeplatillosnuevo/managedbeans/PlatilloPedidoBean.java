/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.managedbeans;

import alfaware.pedidodeplatillosnuevo.controllers.PlatilloPedidoController;
import alfaware.pedidodeplatillosnuevo.entities.Pedido;
import alfaware.pedidodeplatillosnuevo.entities.Platillo;
import alfaware.pedidodeplatillosnuevo.entities.Platillopedido;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author ALFA-AS3-1A6600
 *
 */
@ManagedBean
@Named(value = "platilloPedidoBean")
@SessionScoped
public class PlatilloPedidoBean implements Serializable {

    private String id;
    private String idPlatillo;
    private String idPedido;
    private int cantidad;

    private PlatilloPedidoController platillopedidoController;
    Platillopedido pp = new Platillopedido();

    @PostConstruct
    public void init() {
        platillopedidoController = new PlatilloPedidoController();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(String idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String guardar() {
        this.platillopedidoController.insert(pp, idPlatillo, idPedido, cantidad);
        return "platillopedido";
    }

    public String editar(PlatilloPedidoBean ppb) {
        this.platillopedidoController.update(pp, id, ppb.idPlatillo, ppb.idPedido, ppb.cantidad);
        return "platillopedido";
    }
    
    public String eliminar(){
        this.platillopedidoController.delete(pp, id);
        return "platillopedido";
    }

    public List<Platillopedido> getPlatillopedidos() {
        Map<String, Object> platped = this.platillopedidoController.select(pp);
        List<Platillopedido> result = new ArrayList(platped.values());
        return result;
    }

    /**
     * Creates a new instance of PlatilloPedidoBean
     */
    public PlatilloPedidoBean() {
    }

}
