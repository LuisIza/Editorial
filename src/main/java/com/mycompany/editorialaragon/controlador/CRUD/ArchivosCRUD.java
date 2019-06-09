/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.*;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB1
 */
public class ArchivosCRUD {
    public static void create (ArchivosLibroEa libro){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(libro);
        ses.getTransaction().commit();
        ses.close();
    } 
       /****Buscar todos los archivos por Publicador**/ 
    public static List<ArchivosLibroEa> showArchivos(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM ArchivosLibroEa a where a.idPublicidad=" + id;
        Query query = ses.createQuery(hdl); 
        List<ArchivosLibroEa> libro = query.list();
        ses.close();
        if (libro == null || libro.isEmpty()){
            return null;
        }
        return libro;
    }
    
    public static ArchivosLibroEa showArchivo(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM ArchivosLibroEa a where a.id=" + id;
        Query query = ses.createQuery(hdl); 
        List<ArchivosLibroEa> libro = query.list();
        ses.close();
        if (libro == null || libro.isEmpty()){
            return null;
        }
        return libro.get(0);
    }
    
    public static void deleteArchivo (ArchivosLibroEa libro){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.delete(libro);
        ses.getTransaction().commit();
        ses.close();
    }
    
}
