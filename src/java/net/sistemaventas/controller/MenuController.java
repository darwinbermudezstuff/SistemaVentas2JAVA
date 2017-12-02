/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import net.sistemaventas.ejbs.Busquedas;
import net.sistemaventas.entidades.Menu;
import net.sistemaventas.entidades.Perfiles;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author jpurquilla
 */
@ManagedBean
public class MenuController implements Serializable {

    @EJB
    Busquedas busquedasEJB;
    @Inject
    private Sesion sesion;

    private MenuModel menumodel;

    public MenuModel getMenumodel() {
        return menumodel;
    }

    public void setMenumodel(MenuModel menumodel) {
        this.menumodel = menumodel;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public MenuController() {
    }

    @PostConstruct
    public void init() {
        Perfiles perfil = busquedasEJB.buscarPerfil(sesion.getCodperfil());
        perfil.getMenuList().isEmpty();
        menumodel = new DefaultMenuModel();
        DefaultSubMenu submenu = new DefaultSubMenu("Menu");
        for (Menu menu : perfil.getMenuList()) {
            DefaultMenuItem item = new DefaultMenuItem(menu.getNombre());
            item.setUrl(menu.getUrl());
            submenu.addElement(item);
        }
        menumodel.addElement(submenu);

    }
}
