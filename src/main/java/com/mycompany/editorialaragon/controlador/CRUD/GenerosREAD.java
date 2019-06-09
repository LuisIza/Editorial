/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;
import com.mycompany.editorialaragon.datamodel.entidades.CategoriasLibrosEa;
import com.mycompany.editorialaragon.datamodel.entidades.GenerosEa;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class GenerosREAD {
    
       public static List<GenerosEa> showGeneros(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM GenerosEa c";
        Query query = ses.createQuery(hdl); 
        List<GenerosEa> registros = query.list();
      
        ses.close();
        return registros;
    }
       public static GenerosEa showGenero(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM GenerosEa c where id ="+id;
        Query query = ses.createQuery(hdl); 
        List<GenerosEa> registros = query.list();
        ses.close();
        if (registros.isEmpty()){
            return null;
        }
        return registros.get(0);
    }
       
       public static List<CategoriasLibrosEa> showCategorias(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM CategoriasLibrosEa c where genero = " + id;
        Query query = ses.createQuery(hdl); 
        List<CategoriasLibrosEa> registros = query.list();
      
        ses.close();
        return registros;
    }
       public static CategoriasLibrosEa showCategoria(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM CategoriasLibrosEa c where id = " + id;
        Query query = ses.createQuery(hdl); 
        List<CategoriasLibrosEa> registros = query.list();
      
        ses.close();
         if (registros.isEmpty()){
            return null;
        }
        return registros.get(0);
    }
    
    
}
