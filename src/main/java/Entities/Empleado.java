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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByIDEmp", query = "SELECT e FROM Empleado e WHERE e.iDEmp = :iDEmp"),
    @NamedQuery(name = "Empleado.findByNombreEmp", query = "SELECT e FROM Empleado e WHERE e.nombreEmp = :nombreEmp"),
    @NamedQuery(name = "Empleado.findByApellidoEmp", query = "SELECT e FROM Empleado e WHERE e.apellidoEmp = :apellidoEmp"),
    @NamedQuery(name = "Empleado.findByCorreoEmp", query = "SELECT e FROM Empleado e WHERE e.correoEmp = :correoEmp"),
    @NamedQuery(name = "Empleado.findByContraEmp", query = "SELECT e FROM Empleado e WHERE e.contraEmp = :contraEmp"),
    @NamedQuery(name = "Empleado.findByCargoEmp", query = "SELECT e FROM Empleado e WHERE e.cargoEmp = :cargoEmp")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Emp")
    private Integer iDEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre_Emp")
    private String nombreEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Apellido_Emp")
    private String apellidoEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Correo_Emp")
    private String correoEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "Contra_Emp")
    private String contraEmp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Cargo_Emp")
    private String cargoEmp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDEmpClien", fetch = FetchType.LAZY)
    private List<Cliente> clienteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iDEmpCont", fetch = FetchType.LAZY)
    private List<Contactoempleados> contactoempleadosList;

    public Empleado() {
    }

    public Empleado(Integer iDEmp) {
        this.iDEmp = iDEmp;
    }

    public Empleado(Integer iDEmp, String nombreEmp, String apellidoEmp, String correoEmp, String contraEmp, String cargoEmp) {
        this.iDEmp = iDEmp;
        this.nombreEmp = nombreEmp;
        this.apellidoEmp = apellidoEmp;
        this.correoEmp = correoEmp;
        this.contraEmp = contraEmp;
        this.cargoEmp = cargoEmp;
    }

    public Integer getIDEmp() {
        return iDEmp;
    }

    public void setIDEmp(Integer iDEmp) {
        this.iDEmp = iDEmp;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getApellidoEmp() {
        return apellidoEmp;
    }

    public void setApellidoEmp(String apellidoEmp) {
        this.apellidoEmp = apellidoEmp;
    }

    public String getCorreoEmp() {
        return correoEmp;
    }

    public void setCorreoEmp(String correoEmp) {
        this.correoEmp = correoEmp;
    }

    public String getContraEmp() {
        return contraEmp;
    }

    public void setContraEmp(String contraEmp) {
        this.contraEmp = contraEmp;
    }

    public String getCargoEmp() {
        return cargoEmp;
    }

    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Contactoempleados> getContactoempleadosList() {
        return contactoempleadosList;
    }

    public void setContactoempleadosList(List<Contactoempleados> contactoempleadosList) {
        this.contactoempleadosList = contactoempleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEmp != null ? iDEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.iDEmp == null && other.iDEmp != null) || (this.iDEmp != null && !this.iDEmp.equals(other.iDEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Empleado[ iDEmp=" + iDEmp + " ]";
    }
    
}
