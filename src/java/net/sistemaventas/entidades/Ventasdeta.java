/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
 * @author jpurquilla
 */
@Entity
@Table(name = "VENTASDETA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventasdeta.findAll", query = "SELECT v FROM Ventasdeta v"),
    @NamedQuery(name = "Ventasdeta.findByCantidad", query = "SELECT v FROM Ventasdeta v WHERE v.cantidad = :cantidad"),
    @NamedQuery(name = "Ventasdeta.findByPrecunit", query = "SELECT v FROM Ventasdeta v WHERE v.precunit = :precunit"),
    @NamedQuery(name = "Ventasdeta.findByPrectotalsiva", query = "SELECT v FROM Ventasdeta v WHERE v.prectotalsiva = :prectotalsiva"),
    @NamedQuery(name = "Ventasdeta.findByPrectotal", query = "SELECT v FROM Ventasdeta v WHERE v.prectotal = :prectotal"),
    @NamedQuery(name = "Ventasdeta.findByTotaliva", query = "SELECT v FROM Ventasdeta v WHERE v.totaliva = :totaliva"),
    @NamedQuery(name = "Ventasdeta.findBySerie", query = "SELECT v FROM Ventasdeta v WHERE v.ventasdetaPK.serie = :serie"),
    @NamedQuery(name = "Ventasdeta.findByCodigo", query = "SELECT v FROM Ventasdeta v WHERE v.ventasdetaPK.codigo = :codigo"),
    @NamedQuery(name = "Ventasdeta.findByCorln", query = "SELECT v FROM Ventasdeta v WHERE v.ventasdetaPK.corln = :corln")})
public class Ventasdeta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasdetaPK ventasdetaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private long cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precunit")
    private long precunit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prectotalsiva")
    private long prectotalsiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prectotal")
    private long prectotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "totaliva")
    private String totaliva;
    @JoinColumn(name = "codprod", referencedColumnName = "codprod")
    @ManyToOne(optional = false)
    private Productos codprod;
    @JoinColumns({
        @JoinColumn(name = "serie", referencedColumnName = "serie", insertable = false, updatable = false),
        @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Ventas ventas;
    @OneToMany(mappedBy = "ventasdeta")
    private List<Kardex> kardexList;

    public Ventasdeta() {
    }

    public Ventasdeta(VentasdetaPK ventasdetaPK) {
        this.ventasdetaPK = ventasdetaPK;
    }

    public Ventasdeta(VentasdetaPK ventasdetaPK, long cantidad, long precunit, long prectotalsiva, long prectotal, String totaliva) {
        this.ventasdetaPK = ventasdetaPK;
        this.cantidad = cantidad;
        this.precunit = precunit;
        this.prectotalsiva = prectotalsiva;
        this.prectotal = prectotal;
        this.totaliva = totaliva;
    }

    public Ventasdeta(String serie, int codigo, int corln) {
        this.ventasdetaPK = new VentasdetaPK(serie, codigo, corln);
    }

    public VentasdetaPK getVentasdetaPK() {
        return ventasdetaPK;
    }

    public void setVentasdetaPK(VentasdetaPK ventasdetaPK) {
        this.ventasdetaPK = ventasdetaPK;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getPrecunit() {
        return precunit;
    }

    public void setPrecunit(long precunit) {
        this.precunit = precunit;
    }

    public long getPrectotalsiva() {
        return prectotalsiva;
    }

    public void setPrectotalsiva(long prectotalsiva) {
        this.prectotalsiva = prectotalsiva;
    }

    public long getPrectotal() {
        return prectotal;
    }

    public void setPrectotal(long prectotal) {
        this.prectotal = prectotal;
    }

    public String getTotaliva() {
        return totaliva;
    }

    public void setTotaliva(String totaliva) {
        this.totaliva = totaliva;
    }

    public Productos getCodprod() {
        return codprod;
    }

    public void setCodprod(Productos codprod) {
        this.codprod = codprod;
    }

    public Ventas getVentas() {
        return ventas;
    }

    public void setVentas(Ventas ventas) {
        this.ventas = ventas;
    }

    @XmlTransient
    public List<Kardex> getKardexList() {
        return kardexList;
    }

    public void setKardexList(List<Kardex> kardexList) {
        this.kardexList = kardexList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasdetaPK != null ? ventasdetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventasdeta)) {
            return false;
        }
        Ventasdeta other = (Ventasdeta) object;
        if ((this.ventasdetaPK == null && other.ventasdetaPK != null) || (this.ventasdetaPK != null && !this.ventasdetaPK.equals(other.ventasdetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Ventasdeta[ ventasdetaPK=" + ventasdetaPK + " ]";
    }
    
}
