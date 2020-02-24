/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alfaware.pedidodeplatillosnuevo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ALFA-AS3-1A6600
 */
@Entity
@Table(name = "platillo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platillo.findAll", query = "SELECT p FROM Platillo p")
    , @NamedQuery(name = "Platillo.findById", query = "SELECT p FROM Platillo p WHERE p.id = :id")
    , @NamedQuery(name = "Platillo.findByCostoPrep", query = "SELECT p FROM Platillo p WHERE p.costoPrep = :costoPrep")
    , @NamedQuery(name = "Platillo.findByNombre", query = "SELECT p FROM Platillo p WHERE p.nombre = :nombre")})
public class Platillo implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "costoPrep")
    private Double costoPrep;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idPlatillo")
    private Collection<Platillopedido> platillopedidoCollection;
    @OneToMany(mappedBy = "idPlatillo")
    private Collection<Platilloingrediente> platilloingredienteCollection;

    public Platillo() {
    }

    public Platillo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getCostoPrep() {
        return costoPrep;
    }

    public void setCostoPrep(Double costoPrep) {
        this.costoPrep = costoPrep;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Platillopedido> getPlatillopedidoCollection() {
        return platillopedidoCollection;
    }

    public void setPlatillopedidoCollection(Collection<Platillopedido> platillopedidoCollection) {
        this.platillopedidoCollection = platillopedidoCollection;
    }

    @XmlTransient
    public Collection<Platilloingrediente> getPlatilloingredienteCollection() {
        return platilloingredienteCollection;
    }

    public void setPlatilloingredienteCollection(Collection<Platilloingrediente> platilloingredienteCollection) {
        this.platilloingredienteCollection = platilloingredienteCollection;
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
        if (!(object instanceof Platillo)) {
            return false;
        }
        Platillo other = (Platillo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alfaware.pedidodeplatillosnuevo.entities.Platillo[ id=" + id + " ]";
    }
    
}
