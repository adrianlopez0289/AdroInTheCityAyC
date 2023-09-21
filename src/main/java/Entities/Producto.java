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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author HP
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByNProdu", query = "SELECT p FROM Producto p WHERE p.nProdu = :nProdu"),
    @NamedQuery(name = "Producto.findByNombreProdu", query = "SELECT p FROM Producto p WHERE p.nombreProdu = :nombreProdu"),
    @NamedQuery(name = "Producto.findByPrecioUniprodu", query = "SELECT p FROM Producto p WHERE p.precioUniprodu = :precioUniprodu"),
    @NamedQuery(name = "Producto.findByCantpro", query = "SELECT p FROM Producto p WHERE p.cantpro = :cantpro")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "N_Produ")
    private Integer nProdu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre_Produ")
    private String nombreProdu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrecioUni_produ")
    private int precioUniprodu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantpro")
    private int cantpro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nProductoCateg", fetch = FetchType.LAZY)
    private List<Categoria> categoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nProduProve", fetch = FetchType.LAZY)
    private List<Provedor> provedorList;

    public Producto() {
    }

    public Producto(Integer nProdu) {
        this.nProdu = nProdu;
    }

    public Producto(Integer nProdu, String nombreProdu, int precioUniprodu, int cantpro) {
        this.nProdu = nProdu;
        this.nombreProdu = nombreProdu;
        this.precioUniprodu = precioUniprodu;
        this.cantpro = cantpro;
    }

    public Integer getNProdu() {
        return nProdu;
    }

    public void setNProdu(Integer nProdu) {
        this.nProdu = nProdu;
    }

    public String getNombreProdu() {
        return nombreProdu;
    }

    public void setNombreProdu(String nombreProdu) {
        this.nombreProdu = nombreProdu;
    }

    public int getPrecioUniprodu() {
        return precioUniprodu;
    }

    public void setPrecioUniprodu(int precioUniprodu) {
        this.precioUniprodu = precioUniprodu;
    }

    public int getCantpro() {
        return cantpro;
    }

    public void setCantpro(int cantpro) {
        this.cantpro = cantpro;
    }

    @XmlTransient
    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

    @XmlTransient
    public List<Provedor> getProvedorList() {
        return provedorList;
    }

    public void setProvedorList(List<Provedor> provedorList) {
        this.provedorList = provedorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nProdu != null ? nProdu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.nProdu == null && other.nProdu != null) || (this.nProdu != null && !this.nProdu.equals(other.nProdu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Producto[ nProdu=" + nProdu + " ]";
    }
    
}
