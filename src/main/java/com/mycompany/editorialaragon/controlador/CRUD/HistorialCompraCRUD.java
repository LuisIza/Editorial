/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.HistorialCompras;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class HistorialCompraCRUD {
        public static void create (HistorialCompras historial){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(historial);
        ses.getTransaction().commit();
        ses.close();
    } 
        
    public static  List<HistorialCompras> showHistorial (String email){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
       String hdl = "FROM HistorialCompras h where h.cliente=\'" + email+"\'";
        Query query = ses.createQuery(hdl); 
         List<HistorialCompras> registros = query.list();
        ses.close();
        if (registros.isEmpty()){
            return null; 
        }else{
            return registros;
        }
        
    } 
    
}
