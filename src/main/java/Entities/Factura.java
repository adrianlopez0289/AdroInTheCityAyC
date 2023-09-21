/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByNFactura", query = "SELECT f FROM Factura f WHERE f.nFactura = :nFactura"),
    @NamedQuery(name = "Factura.findByFechaFactura", query = "SELECT f FROM Factura f WHERE f.fechaFactura = :fechaFactura")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "N_Factura")
    private Integer nFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Factura")
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    @JoinColumn(name = "N_Venta_Fac", referencedColumnName = "NVenta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Venta nVentaFac;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nFacturaPediFac", fetch = FetchType.LAZY)
    private List<Pedidofactura> pedidofacturaList;

    public Factura() {
    }

    public Factura(Integer nFactura) {
        this.nFactura = nFactura;
    }

    public Factura(Integer nFactura, Date fechaFactura) {
        this.nFactura = nFactura;
        this.fechaFactura = fechaFactura;
    }

    public Integer getNFactura() {
        return nFactura;
    }

    public void setNFactura(Integer nFactura) {
        this.nFactura = nFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Venta getNVentaFac() {
        return nVentaFac;
    }

    public void setNVentaFac(Venta nVentaFac) {
        this.nVentaFac = nVentaFac;
    }

    @XmlTransient
    public List<Pedidofactura> getPedidofacturaList() {
        return pedidofacturaList;
    }

    public void setPedidofacturaList(List<Pedidofactura> pedidofacturaList) {
        this.pedidofacturaList = pedidofacturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nFactura != null ? nFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.nFactura == null && other.nFactura != null) || (this.nFactura != null && !this.nFactura.equals(other.nFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Factura[ nFactura=" + nFactura + " ]";
    }
    
}
