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
import javax.persistence.ManyToMany;
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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByNVenta", query = "SELECT v FROM Venta v WHERE v.nVenta = :nVenta"),
    @NamedQuery(name = "Venta.findByNomProducto", query = "SELECT v FROM Venta v WHERE v.nomProducto = :nomProducto"),
    @NamedQuery(name = "Venta.findByCanProduct", query = "SELECT v FROM Venta v WHERE v.canProduct = :canProduct"),
    @NamedQuery(name = "Venta.findByValorVenta", query = "SELECT v FROM Venta v WHERE v.valorVenta = :valorVenta")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NVenta")
    private Integer nVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NomProducto")
    private String nomProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CanProduct")
    private int canProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ValorVenta")
    private int valorVenta;
    @ManyToMany(mappedBy = "ventaList", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nVentaFac", fetch = FetchType.LAZY)
    private List<Factura> facturaList;

    public Venta() {
    }

    public Venta(Integer nVenta) {
        this.nVenta = nVenta;
    }

    public Venta(Integer nVenta, String nomProducto, int canProduct, int valorVenta) {
        this.nVenta = nVenta;
        this.nomProducto = nomProducto;
        this.canProduct = canProduct;
        this.valorVenta = valorVenta;
    }

    public Integer getNVenta() {
        return nVenta;
    }

    public void setNVenta(Integer nVenta) {
        this.nVenta = nVenta;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCanProduct() {
        return canProduct;
    }

    public void setCanProduct(int canProduct) {
        this.canProduct = canProduct;
    }

    public int getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(int valorVenta) {
        this.valorVenta = valorVenta;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nVenta != null ? nVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.nVenta == null && other.nVenta != null) || (this.nVenta != null && !this.nVenta.equals(other.nVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Venta[ nVenta=" + nVenta + " ]";
    }
    
}
