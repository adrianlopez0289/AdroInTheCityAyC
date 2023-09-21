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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByNCategoria", query = "SELECT c FROM Categoria c WHERE c.nCategoria = :nCategoria"),
    @NamedQuery(name = "Categoria.findByNombrecatg", query = "SELECT c FROM Categoria c WHERE c.nombrecatg = :nombrecatg")})
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "N_Categoria")
    private Integer nCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Nombre_catg")
    private String nombrecatg;
    @JoinColumn(name = "N_Producto_Categ", referencedColumnName = "N_Produ")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto nProductoCateg;

    public Categoria() {
    }

    public Categoria(Integer nCategoria) {
        this.nCategoria = nCategoria;
    }

    public Categoria(Integer nCategoria, String nombrecatg) {
        this.nCategoria = nCategoria;
        this.nombrecatg = nombrecatg;
    }

    public Integer getNCategoria() {
        return nCategoria;
    }

    public void setNCategoria(Integer nCategoria) {
        this.nCategoria = nCategoria;
    }

    public String getNombrecatg() {
        return nombrecatg;
    }

    public void setNombrecatg(String nombrecatg) {
        this.nombrecatg = nombrecatg;
    }

    public Producto getNProductoCateg() {
        return nProductoCateg;
    }

    public void setNProductoCateg(Producto nProductoCateg) {
        this.nProductoCateg = nProductoCateg;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nCategoria != null ? nCategoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.nCategoria == null && other.nCategoria != null) || (this.nCategoria != null && !this.nCategoria.equals(other.nCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Categoria[ nCategoria=" + nCategoria + " ]";
    }
    
}
