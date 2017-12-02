/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jpurquilla
 */
@Embeddable
public class VentasdetaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corln")
    private int corln;

    public VentasdetaPK() {
    }

    public VentasdetaPK(String serie, int codigo, int corln) {
        this.serie = serie;
        this.codigo = codigo;
        this.corln = corln;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCorln() {
        return corln;
    }

    public void setCorln(int corln) {
        this.corln = corln;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serie != null ? serie.hashCode() : 0);
        hash += (int) codigo;
        hash += (int) corln;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentasdetaPK)) {
            return false;
        }
        VentasdetaPK other = (VentasdetaPK) object;
        if ((this.serie == null && other.serie != null) || (this.serie != null && !this.serie.equals(other.serie))) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.corln != other.corln) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.VentasdetaPK[ serie=" + serie + ", codigo=" + codigo + ", corln=" + corln + " ]";
    }
    
}
