/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.CodigosLibros;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class CodigoLibrosCRUD {
    
    public static void create (CodigosLibros cod){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(cod);
        ses.getTransaction().commit();
        ses.close();
    } 
    
}
