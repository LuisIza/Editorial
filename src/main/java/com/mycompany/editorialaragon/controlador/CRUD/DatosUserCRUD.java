/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.DatosUsuarioEa;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class DatosUserCRUD {
        public static void create (DatosUsuarioEa datos){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(datos);
        ses.getTransaction().commit();
        ses.close();
    } 
}
