/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author luis
 */


public class UserCRUD {
    
    
    /*****BUscar por mail**/
     public static UsuariosEa findUserEmail(String mail) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM UsuariosEa u where u.email=\'" + mail + "\'";
        Query query = ses.createQuery(hdl);
        List<UsuariosEa> usuario = query.list();
        ses.close();
        if (usuario == null || usuario.isEmpty()){
            return null;
        }
        return usuario.get(0);
    }

    public static List<UsuariosEa> showUsuarios() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM UsuariosEa";
        Query query = ses.createQuery(hdl);
        List<UsuariosEa> registros = query.list();
        ses.close();
        if (registros == null || registros.isEmpty()){
            return null;
        }
        return registros;
    }

    public static void updateUser(UsuariosEa user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.update(user);
        ses.getTransaction().commit();
        ses.close();
    }

    public static void create(UsuariosEa user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(user);
        ses.getTransaction().commit();
        ses.close();
    }

    public static void deleteUser(UsuariosEa user) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.delete(user);
        ses.getTransaction().commit();
        ses.close();
    }

    public static Boolean userExiste(String user) {

        UsuariosEa nombre = UserCRUD.findUserEmail(user);
        if (nombre == null) {
            return false;
        } else {
            return true;
        }

    }

    public static Boolean userOkPass(String user, String password) {
        UsuariosEa nombre = UserCRUD.findUserEmail(user);
        
        if (nombre != null) {
            //String passMD5 = MD5.getMD5(password);
            return nombre.getContrasenya().equals(password);
        } else {
            return false;
        }

    }
    /***********************************************/
    /***********************************************
     * 
     */
    
        public static List<?> findUserRest(String mail) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "Select u.email, u.contrasenya, u.permisos FROM UsuariosEa u where u.email=\'" + mail + "\'";
        Query query = ses.createQuery(hdl);
        List<?> usuario = query.list();
        ses.close();
        return usuario;
    }

}
