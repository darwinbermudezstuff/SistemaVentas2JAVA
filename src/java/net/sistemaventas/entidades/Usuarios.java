/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "USUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByCodusr", query = "SELECT u FROM Usuarios u WHERE u.codusr = :codusr"),
    @NamedQuery(name = "Usuarios.findByCodusrClave", query = "SELECT u FROM Usuarios u WHERE u.codusr = :codusr and u.clave = :clave"),
    @NamedQuery(name = "Usuarios.findByNombres", query = "SELECT u FROM Usuarios u WHERE u.nombres = :nombres"),
    @NamedQuery(name = "Usuarios.findByApellidos", query = "SELECT u FROM Usuarios u WHERE u.apellidos = :apellidos"),
    @NamedQuery(name = "Usuarios.findByCargo", query = "SELECT u FROM Usuarios u WHERE u.cargo = :cargo")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codusr")
    private String codusr;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @Column(name = "clave")
    private String clave;
    
    @Column(name = "codperfil")
    private BigInteger codperfil;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codusrmod")
    private List<Clientes> clientesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codusr")
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codusr")
    private List<Ingresos> ingresosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codusrmod")
    private List<Corrfiscal> corrfiscalList;
    
    public Usuarios() {
    }

    public Usuarios(String codusr) {
        this.codusr = codusr;
    }

    public Usuarios(String codusr, String nombres, String apellidos, String cargo) {
        this.codusr = codusr;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cargo = cargo;
    }

    public String getCodusr() {
        return codusr;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public String getClave() {
        return clave;
    }

    public BigInteger getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(BigInteger codperfil) {
        this.codperfil = codperfil;
    }

    
    public void setClave(String clave) {
        this.clave = clave;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public List<Clientes> getClientesList() {
        return clientesList;
    }

    public void setClientesList(List<Clientes> clientesList) {
        this.clientesList = clientesList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<Ingresos> getIngresosList() {
        return ingresosList;
    }

    public void setIngresosList(List<Ingresos> ingresosList) {
        this.ingresosList = ingresosList;
    }

    @XmlTransient
    public List<Corrfiscal> getCorrfiscalList() {
        return corrfiscalList;
    }

    public void setCorrfiscalList(List<Corrfiscal> corrfiscalList) {
        this.corrfiscalList = corrfiscalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusr != null ? codusr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.codusr == null && other.codusr != null) || (this.codusr != null && !this.codusr.equals(other.codusr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Usuarios[ codusr=" + codusr + " ]";
    }
    
}
