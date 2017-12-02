/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jpurquilla
 */
@Entity
@Table(name = "CORRFISCAL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Corrfiscal.findAll", query = "SELECT c FROM Corrfiscal c"),
    @NamedQuery(name = "Corrfiscal.findBySerie", query = "SELECT c FROM Corrfiscal c WHERE c.serie = :serie"),
    @NamedQuery(name = "Corrfiscal.findByCodactual", query = "SELECT c FROM Corrfiscal c WHERE c.codactual = :codactual"),
    @NamedQuery(name = "Corrfiscal.findByCodfinal", query = "SELECT c FROM Corrfiscal c WHERE c.codfinal = :codfinal"),
    @NamedQuery(name = "Corrfiscal.findByCORRFISCALcol", query = "SELECT c FROM Corrfiscal c WHERE c.cORRFISCALcol = :cORRFISCALcol")})
public class Corrfiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "serie")
    private String serie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codactual")
    private int codactual;
    @Column(name = "codfinal")
    private Integer codfinal;
    @Size(max = 45)
    @Column(name = "CORRFISCALcol")
    private String cORRFISCALcol;
    @JoinColumn(name = "codusrmod", referencedColumnName = "codusr")
    @ManyToOne(optional = false)
    private Usuarios codusrmod;

    public Corrfiscal() {
    }

    public Corrfiscal(String serie) {
        this.serie = serie;
    }

    public Corrfiscal(String serie, int codactual) {
        this.serie = serie;
        this.codactual = codactual;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCodactual() {
        return codactual;
    }

    public void setCodactual(int codactual) {
        this.codactual = codactual;
    }

    public Integer getCodfinal() {
        return codfinal;
    }

    public void setCodfinal(Integer codfinal) {
        this.codfinal = codfinal;
    }

    public String getCORRFISCALcol() {
        return cORRFISCALcol;
    }

    public void setCORRFISCALcol(String cORRFISCALcol) {
        this.cORRFISCALcol = cORRFISCALcol;
    }

    public Usuarios getCodusrmod() {
        return codusrmod;
    }

    public void setCodusrmod(Usuarios codusrmod) {
        this.codusrmod = codusrmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serie != null ? serie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corrfiscal)) {
            return false;
        }
        Corrfiscal other = (Corrfiscal) object;
        if ((this.serie == null && other.serie != null) || (this.serie != null && !this.serie.equals(other.serie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.sistemaventas.entidades.Corrfiscal[ serie=" + serie + " ]";
    }
    
}
