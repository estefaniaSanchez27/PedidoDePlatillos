/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@Entity
@Table(name = "platillopedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platillopedido.findAll", query = "SELECT p FROM Platillopedido p")
    , @NamedQuery(name = "Platillopedido.findById", query = "SELECT p FROM Platillopedido p WHERE p.id = :id")
    , @NamedQuery(name = "Platillopedido.findByCantidad", query = "SELECT p FROM Platillopedido p WHERE p.cantidad = :cantidad")})
public class Platillopedido implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idPedido", referencedColumnName = "id")
    @ManyToOne
    private Pedido idPedido;
    @JoinColumn(name = "idPlatillo", referencedColumnName = "id")
    @ManyToOne
    private Platillo idPlatillo;

    public Platillopedido() {
    }

    public Platillopedido(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Platillo getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Platillo idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Platillopedido)) {
            return false;
        }
        Platillopedido other = (Platillopedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alfaware.pedidodeplatillosnuevo.entities.Platillopedido[ id=" + id + " ]";
    }
    
}
