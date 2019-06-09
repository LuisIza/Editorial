/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.SuscriptoresEa;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class SuscriptorCRUD {
        public static void create(SuscriptoresEa sus) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(sus);
        ses.getTransaction().commit();
        ses.close();
    }
    
}
