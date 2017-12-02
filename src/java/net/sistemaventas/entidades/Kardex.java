/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "KARDEX")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kardex.findAll", query = "SELECT k FROM Kardex k"),
    @NamedQuery(name = "Kardex.findByIdtransaccion", query = "SELECT k FROM Kardex k WHERE k.idtransaccion = :idtransaccion"),
    @NamedQuery(name = "Kardex.findByCantidad", query = "SELECT k FROM Kardex k WHERE k.cantidad = :cantidad"),
    @NamedQuery(name = "Kardex.findByCodprod", query = "SELECT k FROM Kardex k WHERE k.codprod = :codprod"),
    @NamedQuery(name = "Kardex.findByFecha", query = "SELECT k FROM Kardex k WHERE k.fecha = :fecha")})
public class Kardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtransaccion")
    private Integer idtransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private long cantidad;
    @Size(max = 10)
    @Column(name = "codprod")
    private String codprod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumns({
        @JoinColumn(name = "corlningrel", referencedColumnName = "corln"),
        @JoinColumn(name = "noingresorel", referencedColumnName = "noingreso")})
    @ManyToOne
    private Ingresos ingresos;
    @JoinColumns({
        @JoinColumn(name = "seriefactrel", referencedColumnName = "serie"),
        @JoinColumn(name = "codigofatcrel", referencedColumnName = "codigo"),
        @JoinColumn(name = "corlnfactrel", referencedColumnName = "corln")})
    @ManyToOne
    private Ventasdeta ventasdeta;

    public Kardex() {
    }

    public Kardex(Integer idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public Kardex(Integer idtransaccion, long cantidad, Date fecha) {
        this.idtransaccion = idtransaccion;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Integer getIdtransaccion() {
        return idtransaccion;
    }

    public void setIdtransaccion(Integer idtransaccion) {
        this.idtransaccion = idtransaccion;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodprod() {
        return codprod;
    }

    public void setCodprod(String codprod) {
        this.codprod = codprod;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Ingresos getIngresos() {
        return ingresos;
    }

    public void setIngresos(Ingresos ingresos) {
        this.ingresos = ingresos;
    }

    public Ventasdeta getVentasdeta() {
        return ventasdeta;
    }

    public void setVentasdeta(Ventasdeta ventasdeta) {
        this.ventasdeta = ventasdeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtransaccion != null ? idtransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kardex)) {
            return false;
        }
        Kardex other = (Kardex) object;
        if ((this.idtransaccion == null && other.idtransaccion != null) || (this.idtransaccion != null && !this.idtransaccion.equals(other.idtransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Kardex[ idtransaccion=" + idtransaccion + " ]";
    }
    
}
