/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIDClien", query = "SELECT c FROM Cliente c WHERE c.iDClien = :iDClien"),
    @NamedQuery(name = "Cliente.findByNombreClien", query = "SELECT c FROM Cliente c WHERE c.nombreClien = :nombreClien"),
    @NamedQuery(name = "Cliente.findByApellidoClien", query = "SELECT c FROM Cliente c WHERE c.apellidoClien = :apellidoClien")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Clien")
    private Integer iDClien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre_Clien")
    private String nombreClien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Apellido_Clien")
    private String apellidoClien;
    @JoinTable(name = "adquicicion", joinColumns = {
        @JoinColumn(name = "ID_Clien_Adq", referencedColumnName = "ID_Clien")}, inverseJoinColumns = {
        @JoinColumn(name = "N_Venta_Adq", referencedColumnName = "NVenta")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Venta> ventaList;
    @JoinColumn(name = "ID_Emp_Clien", referencedColumnName = "ID_Emp")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado iDEmpClien;

    public Cliente() {
    }

    public Cliente(Integer iDClien) {
        this.iDClien = iDClien;
    }

    public Cliente(Integer iDClien, String nombreClien, String apellidoClien) {
        this.iDClien = iDClien;
        this.nombreClien = nombreClien;
        this.apellidoClien = apellidoClien;
    }

    public Integer getIDClien() {
        return iDClien;
    }

    public void setIDClien(Integer iDClien) {
        this.iDClien = iDClien;
    }

    public String getNombreClien() {
        return nombreClien;
    }

    public void setNombreClien(String nombreClien) {
        this.nombreClien = nombreClien;
    }

    public String getApellidoClien() {
        return apellidoClien;
    }

    public void setApellidoClien(String apellidoClien) {
        this.apellidoClien = apellidoClien;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Empleado getIDEmpClien() {
        return iDEmpClien;
    }

    public void setIDEmpClien(Empleado iDEmpClien) {
        this.iDEmpClien = iDEmpClien;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDClien != null ? iDClien.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.iDClien == null && other.iDClien != null) || (this.iDClien != null && !this.iDClien.equals(other.iDClien))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Cliente[ iDClien=" + iDClien + " ]";
    }
    
}
