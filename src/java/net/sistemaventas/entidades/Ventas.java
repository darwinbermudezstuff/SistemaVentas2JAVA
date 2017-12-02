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
import javax.persistence.CascadeType;
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
@Table(name = "VENTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v"),
    @NamedQuery(name = "Ventas.findBySerie", query = "SELECT v FROM Ventas v WHERE v.ventasPK.serie = :serie"),
    @NamedQuery(name = "Ventas.findByCodigo", query = "SELECT v FROM Ventas v WHERE v.ventasPK.codigo = :codigo"),
    @NamedQuery(name = "Ventas.findByFechafact", query = "SELECT v FROM Ventas v WHERE v.fechafact = :fechafact"),
    @NamedQuery(name = "Ventas.findByTotalsiva", query = "SELECT v FROM Ventas v WHERE v.totalsiva = :totalsiva"),
    @NamedQuery(name = "Ventas.findByTotaliva", query = "SELECT v FROM Ventas v WHERE v.totaliva = :totaliva"),
    @NamedQuery(name = "Ventas.findByTotal", query = "SELECT v FROM Ventas v WHERE v.total = :total"),
    @NamedQuery(name = "Ventas.findByAnul", query = "SELECT v FROM Ventas v WHERE v.anul = :anul"),
    @NamedQuery(name = "Ventas.findByFechaanul", query = "SELECT v FROM Ventas v WHERE v.fechaanul = :fechaanul"),
    @NamedQuery(name = "Ventas.findByCodpago", query = "SELECT v FROM Ventas v WHERE v.codpago = :codpago")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentasPK ventasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechafact")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafact;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalsiva")
    private long totalsiva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totaliva")
    private long totaliva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private long total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "anul")
    private int anul;
    @Column(name = "fechaanul")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaanul;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codpago")
    private int codpago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventas")
    private List<Ventasdeta> ventasdetaList;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Clientes idcliente;
    @JoinColumn(name = "codusr", referencedColumnName = "codusr")
    @ManyToOne(optional = false)
    private Usuarios codusr;

    public Ventas() {
    }

    public Ventas(VentasPK ventasPK) {
        this.ventasPK = ventasPK;
    }

    public Ventas(VentasPK ventasPK, Date fechafact, long totalsiva, long totaliva, long total, int anul, int codpago) {
        this.ventasPK = ventasPK;
        this.fechafact = fechafact;
        this.totalsiva = totalsiva;
        this.totaliva = totaliva;
        this.total = total;
        this.anul = anul;
        this.codpago = codpago;
    }

    public Ventas(String serie, int codigo) {
        this.ventasPK = new VentasPK(serie, codigo);
    }

    public VentasPK getVentasPK() {
        return ventasPK;
    }

    public void setVentasPK(VentasPK ventasPK) {
        this.ventasPK = ventasPK;
    }

    public Date getFechafact() {
        return fechafact;
    }

    public void setFechafact(Date fechafact) {
        this.fechafact = fechafact;
    }

    public long getTotalsiva() {
        return totalsiva;
    }

    public void setTotalsiva(long totalsiva) {
        this.totalsiva = totalsiva;
    }

    public long getTotaliva() {
        return totaliva;
    }

    public void setTotaliva(long totaliva) {
        this.totaliva = totaliva;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getAnul() {
        return anul;
    }

    public void setAnul(int anul) {
        this.anul = anul;
    }

    public Date getFechaanul() {
        return fechaanul;
    }

    public void setFechaanul(Date fechaanul) {
        this.fechaanul = fechaanul;
    }

    public int getCodpago() {
        return codpago;
    }

    public void setCodpago(int codpago) {
        this.codpago = codpago;
    }

    @XmlTransient
    public List<Ventasdeta> getVentasdetaList() {
        return ventasdetaList;
    }

    public void setVentasdetaList(List<Ventasdeta> ventasdetaList) {
        this.ventasdetaList = ventasdetaList;
    }

    public Clientes getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Clientes idcliente) {
        this.idcliente = idcliente;
    }

    public Usuarios getCodusr() {
        return codusr;
    }

    public void setCodusr(Usuarios codusr) {
        this.codusr = codusr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ventasPK != null ? ventasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.ventasPK == null && other.ventasPK != null) || (this.ventasPK != null && !this.ventasPK.equals(other.ventasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Ventas[ ventasPK=" + ventasPK + " ]";
    }
    
}
