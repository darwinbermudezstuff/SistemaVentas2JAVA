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
import javax.persistence.ManyToMany;
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
@Table(name = "PERFILES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfiles.findAll", query = "SELECT p FROM Perfiles p"),
    @NamedQuery(name = "Perfiles.findByCodperfil", query = "SELECT p FROM Perfiles p WHERE p.codperfil = :codperfil"),
    @NamedQuery(name = "Perfiles.findByDescripcion", query = "SELECT p FROM Perfiles p WHERE p.descripcion = :descripcion")})
public class Perfiles implements Serializable {

    

    @ManyToMany(mappedBy = "perfilesList")
    private List<Menu> menuList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codperfil")
    private Integer codperfil;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;

    public Perfiles() {
    }

    public Perfiles(Integer codperfil) {
        this.codperfil = codperfil;
    }

    public Integer getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(Integer codperfil) {
        this.codperfil = codperfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codperfil != null ? codperfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfiles)) {
            return false;
        }
        Perfiles other = (Perfiles) object;
        if ((this.codperfil == null && other.codperfil != null) || (this.codperfil != null && !this.codperfil.equals(other.codperfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Perfiles[ codperfil=" + codperfil + " ]";
    }

    @XmlTransient
    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    
    
}
