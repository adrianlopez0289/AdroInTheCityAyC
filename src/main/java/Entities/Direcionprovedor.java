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
@Table(name = "direcionprovedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcionprovedor.findAll", query = "SELECT d FROM Direcionprovedor d"),
    @NamedQuery(name = "Direcionprovedor.findByNiddireccion", query = "SELECT d FROM Direcionprovedor d WHERE d.niddireccion = :niddireccion"),
    @NamedQuery(name = "Direcionprovedor.findByCalleprov", query = "SELECT d FROM Direcionprovedor d WHERE d.calleprov = :calleprov"),
    @NamedQuery(name = "Direcionprovedor.findByCarreraProv", query = "SELECT d FROM Direcionprovedor d WHERE d.carreraProv = :carreraProv"),
    @NamedQuery(name = "Direcionprovedor.findByBarrioProv", query = "SELECT d FROM Direcionprovedor d WHERE d.barrioProv = :barrioProv")})
public class Direcionprovedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "N_iddireccion")
    private Integer niddireccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Calle_prov")
    private int calleprov;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Carrera_Prov")
    private int carreraProv;
    @Size(max = 20)
    @Column(name = "Barrio_Prov")
    private String barrioProv;
    @JoinColumn(name = "Id_prov_direc", referencedColumnName = "Id_prov")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Provedor idprovdirec;

    public Direcionprovedor() {
    }

    public Direcionprovedor(Integer niddireccion) {
        this.niddireccion = niddireccion;
    }

    public Direcionprovedor(Integer niddireccion, int calleprov, int carreraProv) {
        this.niddireccion = niddireccion;
        this.calleprov = calleprov;
        this.carreraProv = carreraProv;
    }

    public Integer getNiddireccion() {
        return niddireccion;
    }

    public void setNiddireccion(Integer niddireccion) {
        this.niddireccion = niddireccion;
    }

    public int getCalleprov() {
        return calleprov;
    }

    public void setCalleprov(int calleprov) {
        this.calleprov = calleprov;
    }

    public int getCarreraProv() {
        return carreraProv;
    }

    public void setCarreraProv(int carreraProv) {
        this.carreraProv = carreraProv;
    }

    public String getBarrioProv() {
        return barrioProv;
    }

    public void setBarrioProv(String barrioProv) {
        this.barrioProv = barrioProv;
    }

    public Provedor getIdprovdirec() {
        return idprovdirec;
    }

    public void setIdprovdirec(Provedor idprovdirec) {
        this.idprovdirec = idprovdirec;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (niddireccion != null ? niddireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Direcionprovedor)) {
            return false;
        }
        Direcionprovedor other = (Direcionprovedor) object;
        if ((this.niddireccion == null && other.niddireccion != null) || (this.niddireccion != null && !this.niddireccion.equals(other.niddireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Direcionprovedor[ niddireccion=" + niddireccion + " ]";
    }
    
}
