/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "INGRESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresos.findAll", query = "SELECT i FROM Ingresos i"),
    @NamedQuery(name = "Ingresos.findByNoingreso", query = "SELECT i FROM Ingresos i WHERE i.ingresosPK.noingreso = :noingreso"),
    @NamedQuery(name = "Ingresos.findByCorln", query = "SELECT i FROM Ingresos i WHERE i.ingresosPK.corln = :corln"),
    @NamedQuery(name = "Ingresos.findByCantidad", query = "SELECT i FROM Ingresos i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "Ingresos.findByFecha", query = "SELECT i FROM Ingresos i WHERE i.fecha = :fecha")})
public class Ingresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngresosPK ingresosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private long cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "codprod", referencedColumnName = "codprod")
    @ManyToOne(optional = false)
    private Productos codprod;
    @JoinColumn(name = "codusr", referencedColumnName = "codusr")
    @ManyToOne(optional = false)
    private Usuarios codusr;
    @OneToMany(mappedBy = "ingresos")
    private List<Kardex> kardexList;

    public Ingresos() {
    }

    public Ingresos(IngresosPK ingresosPK) {
        this.ingresosPK = ingresosPK;
    }

    public Ingresos(IngresosPK ingresosPK, long cantidad, Date fecha) {
        this.ingresosPK = ingresosPK;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Ingresos(int noingreso, int corln) {
        this.ingresosPK = new IngresosPK(noingreso, corln);
    }

    public IngresosPK getIngresosPK() {
        return ingresosPK;
    }

    public void setIngresosPK(IngresosPK ingresosPK) {
        this.ingresosPK = ingresosPK;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Productos getCodprod() {
        return codprod;
    }

    public void setCodprod(Productos codprod) {
        this.codprod = codprod;
    }

    public Usuarios getCodusr() {
        return codusr;
    }

    public void setCodusr(Usuarios codusr) {
        this.codusr = codusr;
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
        hash += (ingresosPK != null ? ingresosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresos)) {
            return false;
        }
        Ingresos other = (Ingresos) object;
        if ((this.ingresosPK == null && other.ingresosPK != null) || (this.ingresosPK != null && !this.ingresosPK.equals(other.ingresosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Ingresos[ ingresosPK=" + ingresosPK + " ]";
    }
    
}
