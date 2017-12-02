/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sistemaventas.ejbs;

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import net.sistemaventas.entidades.Menu;
import net.sistemaventas.entidades.Perfiles;
import net.sistemaventas.entidades.Usuarios;

/**
 *
 * @author jpurquilla
 */
@Stateless
public class Busquedas {

    @PersistenceContext(unitName = "SistemaVentasPU")
    private EntityManager em;
    
    /**
     * Metodo para buscar los Usuarios
     * @param codusr. Codigo de usuario
     * @param password. Password a consultar.
     * @return
     * @throws Exception 
     */
    public Usuarios buscarUsuario(String codusr, String password) throws Exception{
        try {
            
            StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT u FROM Usuarios u WHERE u.codusr = :codusr and u.clave = :clave");
            
            Query q = em.createQuery(jpql.toString());
            q.setParameter("clave", password);
            q.setParameter("codusr", codusr);
            
            return (Usuarios) q.getSingleResult();
            
        } catch (NoResultException nre) {
            Logger.getLogger(this.getClass().getName()).log(
                    Level.WARNING, "No se encontraron Registros: ", nre);
            return null;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(
                    Level.SEVERE, "Error al consultar los Usuarios ", e);
            throw e;
        }
    }
    
    public Perfiles buscarPerfil (BigInteger codperfil) {
        try {
            
            StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT p FROM Perfiles p WHERE p.codperfil = :codperfil");
            
            Query q = em.createQuery(jpql.toString());
            q.setParameter("codperfil", codperfil);
           
            return (Perfiles) q.getSingleResult();
            
        } catch (NoResultException nre) {
            Logger.getLogger(this.getClass().getName()).log(
                    Level.WARNING, "No se encontraron Registros: ", nre);
            return null;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(
                    Level.SEVERE, "Error al consultar los Perfiles ", e);
            throw e;
        }
    }
    
    public List < Menu > buscarmenu (BigInteger codperfil) {
        try {
            
            StringBuilder jpql = new StringBuilder();
            jpql.append("SELECT m FROM Menu m WHERE m.codperfil = :codperfil");
            
            Query q = em.createQuery(jpql.toString());
            q.setParameter("codperfil", codperfil.intValue());
           
            return  q.getResultList();
            
        } catch (NoResultException nre) {
            Logger.getLogger(this.getClass().getName()).log(
                    Level.WARNING, "No se encontraron Registros: ", nre);
            return null;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(
                    Level.SEVERE, "Error al consultar los Menu ", e);
            throw e;
        }
    }
    
    

    
}
