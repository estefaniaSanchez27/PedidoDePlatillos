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
@Table(name = "platilloingrediente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Platilloingrediente.findAll", query = "SELECT p FROM Platilloingrediente p")
    , @NamedQuery(name = "Platilloingrediente.findById", query = "SELECT p FROM Platilloingrediente p WHERE p.id = :id")
    , @NamedQuery(name = "Platilloingrediente.findByGramos", query = "SELECT p FROM Platilloingrediente p WHERE p.gramos = :gramos")})
public class Platilloingrediente implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gramos")
    private Double gramos;
    @JoinColumn(name = "idIngrediente", referencedColumnName = "id")
    @ManyToOne
    private Ingrediente idIngrediente;
    @JoinColumn(name = "idPlatillo", referencedColumnName = "id")
    @ManyToOne
    private Platillo idPlatillo;

    public Platilloingrediente() {
    }

    public Platilloingrediente(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getGramos() {
        return gramos;
    }

    public void setGramos(Double gramos) {
        this.gramos = gramos;
    }

    public Ingrediente getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Ingrediente idIngrediente) {
        this.idIngrediente = idIngrediente;
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
        if (!(object instanceof Platilloingrediente)) {
            return false;
        }
        Platilloingrediente other = (Platilloingrediente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "alfaware.pedidodeplatillosnuevo.entities.Platilloingrediente[ id=" + id + " ]";
    }
    
}
