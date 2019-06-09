/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Luis
 */
public class PedidosImpresosCRUD {
    
    public static void create (PedidosImpresos pedido){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(pedido);
        ses.getTransaction().commit();
        ses.close();
    } 
    public static  List<PedidosImpresos> showPedidos (String email){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
       String hdl = "FROM PedidosImpresos h where h.cliente=\'" + email+"\'";
        Query query = ses.createQuery(hdl); 
         List<PedidosImpresos> registros = query.list();
        ses.close();
        if (registros.isEmpty()){
            return null; 
        }else{
            return registros;
        }
        
    } 
    
}
