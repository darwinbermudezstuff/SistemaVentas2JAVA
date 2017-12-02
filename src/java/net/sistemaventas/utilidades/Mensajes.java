/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.utilidades;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author jpurquilla
 */
public class Mensajes implements Serializable {
    public void showMsj (int severity, String mensaje) {
        FacesMessage fmsg = null ;
        if (severity == 0) {
                fmsg = new FacesMessage(
                   FacesMessage.SEVERITY_INFO, "Info: " , mensaje);
            
            }
            if (severity == 1) {
                fmsg = new FacesMessage(
                   FacesMessage.SEVERITY_WARN, "Warning: ", mensaje);
              
            }
            if (severity == 2) {
                fmsg = new FacesMessage(
                   FacesMessage.SEVERITY_ERROR, "Error: ", mensaje);
            }
            if (severity == 3) {
                fmsg = new FacesMessage(
                   FacesMessage.SEVERITY_FATAL, "Fatal.", mensaje);
            }
            FacesContext.getCurrentInstance().addMessage(null,fmsg);
    }
}
