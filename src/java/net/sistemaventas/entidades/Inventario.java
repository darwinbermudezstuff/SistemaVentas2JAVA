/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "INVENTARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByCantStock", query = "SELECT i FROM Inventario i WHERE i.cantStock = :cantStock"),
    @NamedQuery(name = "Inventario.findByCodprod", query = "SELECT i FROM Inventario i WHERE i.codprod = :codprod")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_stock")
    private int cantStock;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codprod")
    private String codprod;
    @JoinColumn(name = "codprod", referencedColumnName = "codprod", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Productos productos;

    public Inventario() {
    }

    public Inventario(String codprod) {
        this.codprod = codprod;
    }

    public Inventario(String codprod, int cantStock) {
        this.codprod = codprod;
        this.cantStock = cantStock;
    }

    public int getCantStock() {
        return cantStock;
    }

    public void setCantStock(int cantStock) {
        this.cantStock = cantStock;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
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
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.codprod == null && other.codprod != null) || (this.codprod != null && !this.codprod.equals(other.codprod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Inventario[ codprod=" + codprod + " ]";
    }
    
}
