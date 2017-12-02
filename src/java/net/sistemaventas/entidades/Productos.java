/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "PRODUCTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p"),
    @NamedQuery(name = "Productos.findByCodprod", query = "SELECT p FROM Productos p WHERE p.codprod = :codprod"),
    @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Productos.findByPreciosiva", query = "SELECT p FROM Productos p WHERE p.preciosiva = :preciosiva")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codprod")
    private String codprod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "preciosiva")
    private String preciosiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private List<Ventasdeta> ventasdetaList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "productos")
    private Inventario inventario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codprod")
    private List<Ingresos> ingresosList;

    public Productos() {
    }

    public Productos(String codprod) {
        this.codprod = codprod;
    }

    public Productos(String codprod, String descripcion, String preciosiva) {
        this.codprod = codprod;
        this.descripcion = descripcion;
        this.preciosiva = preciosiva;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPreciosiva() {
        return preciosiva;
    }

    public void setPreciosiva(String preciosiva) {
        this.preciosiva = preciosiva;
    }

    @XmlTransient
    public List<Ventasdeta> getVentasdetaList() {
        return ventasdetaList;
    }

    public void setVentasdetaList(List<Ventasdeta> ventasdetaList) {
        this.ventasdetaList = ventasdetaList;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @XmlTransient
    public List<Ingresos> getIngresosList() {
        return ingresosList;
    }

    public void setIngresosList(List<Ingresos> ingresosList) {
        this.ingresosList = ingresosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprod != null ? codprod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Productos[ codprod=" + codprod + " ]";
    }
    
}
