/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "pedidofactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidofactura.findAll", query = "SELECT p FROM Pedidofactura p"),
    @NamedQuery(name = "Pedidofactura.findByNPedidoFactu", query = "SELECT p FROM Pedidofactura p WHERE p.nPedidoFactu = :nPedidoFactu"),
    @NamedQuery(name = "Pedidofactura.findByFechaPedidoFactu", query = "SELECT p FROM Pedidofactura p WHERE p.fechaPedidoFactu = :fechaPedidoFactu")})
public class Pedidofactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "N_Pedido_Factu")
    private Integer nPedidoFactu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Pedido_Factu")
    @Temporal(TemporalType.DATE)
    private Date fechaPedidoFactu;
    @JoinColumn(name = "N_Factura_PediFac", referencedColumnName = "N_Factura")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Factura nFacturaPediFac;

    public Pedidofactura() {
    }

    public Pedidofactura(Integer nPedidoFactu) {
        this.nPedidoFactu = nPedidoFactu;
    }

    public Pedidofactura(Integer nPedidoFactu, Date fechaPedidoFactu) {
        this.nPedidoFactu = nPedidoFactu;
        this.fechaPedidoFactu = fechaPedidoFactu;
    }

    public Integer getNPedidoFactu() {
        return nPedidoFactu;
    }

    public void setNPedidoFactu(Integer nPedidoFactu) {
        this.nPedidoFactu = nPedidoFactu;
    }

    public Date getFechaPedidoFactu() {
        return fechaPedidoFactu;
    }

    public void setFechaPedidoFactu(Date fechaPedidoFactu) {
        this.fechaPedidoFactu = fechaPedidoFactu;
    }

    public Factura getNFacturaPediFac() {
        return nFacturaPediFac;
    }

    public void setNFacturaPediFac(Factura nFacturaPediFac) {
        this.nFacturaPediFac = nFacturaPediFac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nPedidoFactu != null ? nPedidoFactu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidofactura)) {
            return false;
        }
        Pedidofactura other = (Pedidofactura) object;
        if ((this.nPedidoFactu == null && other.nPedidoFactu != null) || (this.nPedidoFactu != null && !this.nPedidoFactu.equals(other.nPedidoFactu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Pedidofactura[ nPedidoFactu=" + nPedidoFactu + " ]";
    }
    
}
