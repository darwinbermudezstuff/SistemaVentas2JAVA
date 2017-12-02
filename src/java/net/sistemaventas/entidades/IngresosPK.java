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

/**
 *
 * @author jpurquilla
 */
@Embeddable
public class IngresosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "noingreso")
    private int noingreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "corln")
    private int corln;

    public IngresosPK() {
    }

    public IngresosPK(int noingreso, int corln) {
        this.noingreso = noingreso;
        this.corln = corln;
    }

    public int getNoingreso() {
        return noingreso;
    }

    public void setNoingreso(int noingreso) {
        this.noingreso = noingreso;
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
        hash += (int) noingreso;
        hash += (int) corln;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresosPK)) {
            return false;
        }
        IngresosPK other = (IngresosPK) object;
        if (this.noingreso != other.noingreso) {
            return false;
        }
        if (this.corln != other.corln) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.IngresosPK[ noingreso=" + noingreso + ", corln=" + corln + " ]";
    }
    
}
