/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author jpurquilla
 */
@Named(value = "sesion")
@SessionScoped
public class Sesion implements Serializable {

    private String nombre;
    private String codusr;
    private String cargo;
    private BigInteger codperfil;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodusr() {
        return codusr;
    }

    public void setCodusr(String codusr) {
        this.codusr = codusr;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigInteger getCodperfil() {
        return codperfil;
    }

    public void setCodperfil(BigInteger codperfil) {
        this.codperfil = codperfil;
    }
    

    /**
     * Creates a new instance of sesion
     */
    public Sesion() {
    }

}
