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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "CLIENTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdcliente", query = "SELECT c FROM Clientes c WHERE c.idcliente = :idcliente"),
    @NamedQuery(name = "Clientes.findByNombres", query = "SELECT c FROM Clientes c WHERE c.nombres = :nombres"),
    @NamedQuery(name = "Clientes.findByApellidos", query = "SELECT c FROM Clientes c WHERE c.apellidos = :apellidos"),
    @NamedQuery(name = "Clientes.findByDui", query = "SELECT c FROM Clientes c WHERE c.dui = :dui"),
    @NamedQuery(name = "Clientes.findByNit", query = "SELECT c FROM Clientes c WHERE c.nit = :nit"),
    @NamedQuery(name = "Clientes.findByCredfiscal", query = "SELECT c FROM Clientes c WHERE c.credfiscal = :credfiscal"),
    @NamedQuery(name = "Clientes.findByCondcredito", query = "SELECT c FROM Clientes c WHERE c.condcredito = :condcredito"),
    @NamedQuery(name = "Clientes.findByFechareg", query = "SELECT c FROM Clientes c WHERE c.fechareg = :fechareg")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "apellidos")
    private String apellidos;
    @Size(max = 20)
    @Column(name = "dui")
    private String dui;
    @Size(max = 25)
    @Column(name = "nit")
    private String nit;
    @Size(max = 45)
    @Column(name = "credfiscal")
    private String credfiscal;
    @Column(name = "condcredito")
    private Integer condcredito;
    @Column(name = "fechareg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechareg;
    @JoinColumn(name = "codusrmod", referencedColumnName = "codusr")
    @ManyToOne(optional = false)
    private Usuarios codusrmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Ventas> ventasList;

    public Clientes() {
    }

    public Clientes(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Clientes(Integer idcliente, String nombres, String apellidos) {
        this.idcliente = idcliente;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCredfiscal() {
        return credfiscal;
    }

    public void setCredfiscal(String credfiscal) {
        this.credfiscal = credfiscal;
    }

    public Integer getCondcredito() {
        return condcredito;
    }

    public void setCondcredito(Integer condcredito) {
        this.condcredito = condcredito;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public Usuarios getCodusrmod() {
        return codusrmod;
    }

    public void setCodusrmod(Usuarios codusrmod) {
        this.codusrmod = codusrmod;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Clientes[ idcliente=" + idcliente + " ]";
    }
    
}
