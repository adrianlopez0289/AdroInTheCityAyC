/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * @author HP
 */
@Entity
@Table(name = "contactoempleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contactoempleados.findAll", query = "SELECT c FROM Contactoempleados c"),
    @NamedQuery(name = "Contactoempleados.findByCorreoEmp", query = "SELECT c FROM Contactoempleados c WHERE c.correoEmp = :correoEmp"),
    @NamedQuery(name = "Contactoempleados.findByTelefono1Emp", query = "SELECT c FROM Contactoempleados c WHERE c.telefono1Emp = :telefono1Emp"),
    @NamedQuery(name = "Contactoempleados.findByTelefono2Emp", query = "SELECT c FROM Contactoempleados c WHERE c.telefono2Emp = :telefono2Emp")})
public class Contactoempleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "Correo_Emp")
    private String correoEmp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono1_Emp")
    private int telefono1Emp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Telefono2_Emp")
    private int telefono2Emp;
    @JoinColumn(name = "ID_Emp_Cont", referencedColumnName = "ID_Emp")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado iDEmpCont;

    public Contactoempleados() {
    }

    public Contactoempleados(String correoEmp) {
        this.correoEmp = correoEmp;
    }

    public Contactoempleados(String correoEmp, int telefono1Emp, int telefono2Emp) {
        this.correoEmp = correoEmp;
        this.telefono1Emp = telefono1Emp;
        this.telefono2Emp = telefono2Emp;
    }

    public String getCorreoEmp() {
        return correoEmp;
    }

    public void setCorreoEmp(String correoEmp) {
        this.correoEmp = correoEmp;
    }

    public int getTelefono1Emp() {
        return telefono1Emp;
    }

    public void setTelefono1Emp(int telefono1Emp) {
        this.telefono1Emp = telefono1Emp;
    }

    public int getTelefono2Emp() {
        return telefono2Emp;
    }

    public void setTelefono2Emp(int telefono2Emp) {
        this.telefono2Emp = telefono2Emp;
    }

    public Empleado getIDEmpCont() {
        return iDEmpCont;
    }

    public void setIDEmpCont(Empleado iDEmpCont) {
        this.iDEmpCont = iDEmpCont;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correoEmp != null ? correoEmp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contactoempleados)) {
            return false;
        }
        Contactoempleados other = (Contactoempleados) object;
        if ((this.correoEmp == null && other.correoEmp != null) || (this.correoEmp != null && !this.correoEmp.equals(other.correoEmp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Contactoempleados[ correoEmp=" + correoEmp + " ]";
    }
    
}
