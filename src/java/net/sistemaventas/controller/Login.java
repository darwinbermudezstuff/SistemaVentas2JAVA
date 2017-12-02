/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import net.sistemaventas.ejbs.Busquedas;
import net.sistemaventas.entidades.Usuarios;
import net.sistemaventas.utilidades.Mensajes;

/**
 *
 * @author jpurquilla
 */
@Named(value = "login")
@ViewScoped
public class Login implements Serializable{
    @EJB
    Busquedas busquedasEJB;
    @Inject
    private Mensajes mensaje;
    @Inject
    private Sesion sesion;
    
    
    private boolean loggueado;
    private String usuario = "";
    private String password = "";

    

    //<editor-fold desc="getter y setter" default-state="collapsed">
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    //</editor-fold>
    /**
     * Creates a new instance of login
     */
    public Login() {
    }
    
    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    
    
    public void validarIngreso() {
        try {
            
            
            //usuario = null;
            if (usuario.isEmpty() || password.isEmpty()) {
                mensaje.showMsj(1, "Ingrese usuario y password");
                return;
            }
            
            Usuarios user = busquedasEJB.buscarUsuario(usuario, password);
            
            loggueado = (user != null);
            
            if (loggueado) {
                if (user.getCargo() != null) {
                    sesion.setCargo(user.getCargo());
                }
                if (user.getNombres() != null) {
                    sesion.setNombre(user.getNombres());
                }
                sesion.setCodusr(usuario);
                sesion.setCodperfil(user.getCodperfil());
               
            } else {
                mensaje.showMsj(1, "usuario y password incorrectos");
            }

        } catch (Exception e) {
            mensaje.showMsj(2, "Error al validar el usuario");
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public String redirect() {
        if (loggueado) {
            return "/Principal.xhtml?faces-redirect=true";
        }
        return null;
    }
    
}
