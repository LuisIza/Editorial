/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.controlador.PrecioListado;
import com.mycompany.editorialaragon.datamodel.entidades.*;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class CrearLibroCRUD {
    public static List<ProductosEa> showPrecios(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM ProductosEa p";
        Query query = ses.createQuery(hdl); 
        List<ProductosEa> registros = query.list();
        ses.close();
        return registros;
    }
    
     public static ProductosEa showProducto(String codigo){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM ProductosEa p where p.id ='" + codigo +"'";
        Query query = ses.createQuery(hdl); 
        List<ProductosEa> registros = query.list();
        ses.close();
        return registros.get(0);
    }
    
    public static BigDecimal showPrecio(String cod){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "Select p.precio FROM ProductosEa p where p.id ='"+cod+"'";
        Query query = ses.createQuery(hdl); 
        BigDecimal registros = (BigDecimal) query.uniqueResult();
        ses.close();
        return registros;
    }
    
       
}
