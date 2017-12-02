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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "MENU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByCodmenu", query = "SELECT m FROM Menu m WHERE m.codmenu = :codmenu"),
    @NamedQuery(name = "Menu.findByNombre", query = "SELECT m FROM Menu m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Menu.findByUrl", query = "SELECT m FROM Menu m WHERE m.url = :url")})
public class Menu implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codmenu")
    private Integer codmenu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "url")
    private String url;
    
     @JoinTable(name = "MENUPERFIL", joinColumns = {
        @JoinColumn(name = "codmenu", referencedColumnName = "codmenu")}, inverseJoinColumns = {
        @JoinColumn(name = "codperfil", referencedColumnName = "codperfil")})
    @ManyToMany
    private List<Perfiles> perfilesList;

    public Menu() {
    }

    public Menu(Integer codmenu) {
        this.codmenu = codmenu;
    }

    public Menu(Integer codmenu, String nombre, String url) {
        this.codmenu = codmenu;
        this.nombre = nombre;
        this.url = url;
    }

    public Integer getCodmenu() {
        return codmenu;
    }

    public void setCodmenu(Integer codmenu) {
        this.codmenu = codmenu;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codmenu != null ? codmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.codmenu == null && other.codmenu != null) || (this.codmenu != null && !this.codmenu.equals(other.codmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Menu[ codmenu=" + codmenu + " ]";
    }

    @XmlTransient
    public List<Perfiles> getPerfilesList() {
        return perfilesList;
    }

    public void setPerfilesList(List<Perfiles> perfilesList) {
        this.perfilesList = perfilesList;
    }
    
}
