/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author HP
 */
@Entity
@Table(name = "provedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provedor.findAll", query = "SELECT p FROM Provedor p"),
    @NamedQuery(name = "Provedor.findByIdprov", query = "SELECT p FROM Provedor p WHERE p.idprov = :idprov"),
    @NamedQuery(name = "Provedor.findByCompa\u00f1iaprov", query = "SELECT p FROM Provedor p WHERE p.compa\u00f1iaprov = :compa\u00f1iaprov")})
public class Provedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id_prov")
    private Integer idprov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Compa\u00f1ia_prov")
    private String compañiaprov;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idprovdirec", fetch = FetchType.LAZY)
    private List<Direcionprovedor> direcionprovedorList;
    @JoinColumn(name = "N_Produ_Prove", referencedColumnName = "N_Produ")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto nProduProve;

    public Provedor() {
    }

    public Provedor(Integer idprov) {
        this.idprov = idprov;
    }

    public Provedor(Integer idprov, String compañiaprov) {
        this.idprov = idprov;
        this.compañiaprov = compañiaprov;
    }

    public Integer getIdprov() {
        return idprov;
    }

    public void setIdprov(Integer idprov) {
        this.idprov = idprov;
    }

    public String getCompañiaprov() {
        return compañiaprov;
    }

    public void setCompañiaprov(String compañiaprov) {
        this.compañiaprov = compañiaprov;
    }

    @XmlTransient
    public List<Direcionprovedor> getDirecionprovedorList() {
        return direcionprovedorList;
    }

    public void setDirecionprovedorList(List<Direcionprovedor> direcionprovedorList) {
        this.direcionprovedorList = direcionprovedorList;
    }

    public Producto getNProduProve() {
        return nProduProve;
    }

    public void setNProduProve(Producto nProduProve) {
        this.nProduProve = nProduProve;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprov != null ? idprov.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provedor)) {
            return false;
        }
        Provedor other = (Provedor) object;
        if ((this.idprov == null && other.idprov != null) || (this.idprov != null && !this.idprov.equals(other.idprov))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Provedor[ idprov=" + idprov + " ]";
    }
    
}
