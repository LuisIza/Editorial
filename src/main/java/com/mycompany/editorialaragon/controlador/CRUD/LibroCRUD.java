/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.CRUD;

import com.mycompany.editorialaragon.datamodel.entidades.*;
import com.mycompany.editorialaragon.hibernate.HibernateUtil;
import com.mycompany.editorialaragon.webservice.datos.LibroCliente;
import com.mycompany.editorialaragon.webservice.datos.LibroVenta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author WEB1
 */
public class LibroCRUD {
    
    public static void create (LibroPublicadoEa libro){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.save(libro);
        ses.getTransaction().commit();
        ses.close();
    }  
    public static void updateLibro (LibroPublicadoEa libro){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.update(libro);
        ses.getTransaction().commit();
        ses.close();
    }  
        
    public static void deleteLibro (LibroPublicadoEa libro){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        ses.beginTransaction();
        ses.delete(libro);
        ses.getTransaction().commit();
        ses.close();
    }  
    
    /*Busqueda por id de libro*/
    public static LibroPublicadoEa showLibro(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM LibroPublicadoEa p where p.id=" + id;
        Query query = ses.createQuery(hdl); 
        List<LibroPublicadoEa> libro = query.list();
        ses.close();
        if (libro == null || libro.isEmpty()){
            return null;
        }
        return libro.get(0);
    }
    
    /*********Retorna objeto usuario de un libro*****************/
    public static UsuariosEa LibroMail(int id){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM LibroPublicadoEa p where p.id=" + id;
        Query query = ses.createQuery(hdl); 
        List<LibroPublicadoEa> libro = query.list();
        ses.close();
        if (libro == null || libro.isEmpty()){
            return null;
        }
        return libro.get(0).getEmail();
    }
    
    /*Busqueda de libros por idautor*/    
    public static List<LibroPublicadoEa> showLibros(String mail){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM LibroPublicadoEa p where p.email =\'" + mail+"\'";
        Query query = ses.createQuery(hdl); 
        List<LibroPublicadoEa> registros = query.list();
        ses.close();
        return registros;
    }
  
        
    
    /*Busqueda de todos los libros*/
    public static List<LibroPublicadoEa> showAllLibros(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM LibroPublicadoEa";
        Query query = ses.createQuery(hdl); 
        List<LibroPublicadoEa> registros = query.list();
        ses.close();
        return registros;
    }
    
    
        
    public static List<LibroPublicadoEa> librosAutorizacion(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM LibroPublicadoEa l where l.estado = 'Solicitando'";
        Query query = ses.createQuery(hdl); 
        List<LibroPublicadoEa> registros = query.list();
        ses.close();
        if (registros.isEmpty()){
            return null;
        }
        return registros;
    }
    
    
    /*************publicados por el administrador autorizacion ok**/
    public static List<LibroPublicadoEa> showAllLibrosVenta(){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "FROM LibroPublicadoEa l where l.estado = 'Publicado'";
        Query query = ses.createQuery(hdl); 
        List<LibroPublicadoEa> registros = query.list();
        ses.close();
        if (registros.isEmpty()){
            return null;
        }
        return registros;
    }
    
    
    
      
    /****REST PARA LIBROS DE UN USUARIO***/
    /*public static List<?> showLibrosPub(String mail){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "Select p.id, p.nombreLibro, p.categoria, p.descripcion, p.autor, p.editorial, p.urlPortada FROM LibroPublicadoEa p where p.email =\'" + mail+"\'";
        Query query = ses.createQuery(hdl); 
        List<?> registros = query.list();
        ses.close();
        return registros;
    }*/
    
        public static List<LibroCliente> LibrosPub(String mail){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        String hdl = "Select p.id, p.nombreLibro, p.categoria, p.descripcion, p.autor, p.editorial, p.urlPortada FROM LibroPublicadoEa p where p.email =\'" + mail+"\'";
        Query query = ses.createQuery(hdl); 
        List<Object[]> registros = query.list();
        List<LibroCliente> reglib = new ArrayList();
        //LibroCliente libw = new LibroCliente();
        ses.close();
        for (Object[] ll : registros){
            LibroCliente libw = new LibroCliente();
            libw.setId((Integer) ll[0]);
            libw.setNombreLibro((String) ll[1]);
            libw.setCategoria((String) ll[2]);
            libw.setDescripcion((String) ll[3]);
            libw.setAutor((String) ll[4]);
            libw.setEditorial((String) ll[5]);
            libw.setUrlPortada((String) ll[6]);
            reglib.add(libw);
        }
        return reglib;
    }
    public static List<LibroVenta> LibrosVenta(int num){
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session ses = sf.openSession();
        int inicio= num*2;
        int fin=2;
        String hdl = "Select p.id, p.nombreLibro, p.genero, p.categoria, p.descripcion, p.autor, p.editorial, p.urlPortada, p.idioma, p.isbn, p.paginas, p.digital, p.impreso , a.urlArchivo "
               + "FROM LibroPublicadoEa p, ArchivosLibroEa a where p.estado ='Publicado' and p.id = a.idPublicidad ";
        //String hdl = "Select p.id, p.nombreLibro, p.genero, p.categoria, p.descripcion, p.autor, p.editorial, p.urlPortada, p.idioma, p.isbn, p.paginas, p.digital, p.impreso , a.urlArchivo "
          //+ "FROM LibroPublicadoEa p, ArchivosLibroEa a where p.estado ='Publicado' and p.id = a.idPublicidad limit "+inicio+","+fin;
        Query query = ses.createQuery(hdl).setFirstResult(inicio).setMaxResults(fin); 
        //query.setFirstResult(1).setMaxResults(4);
        List<Object[]> registros = query.list();
        List<LibroVenta> reglib = new ArrayList();
        //LibroCliente libw = new LibroCliente();
        ses.close();
        if (registros.isEmpty()){
            return null;
        }
        for (Object[] ll : registros){
            LibroVenta libw = new LibroVenta();
            libw.setId((Integer) ll[0]);
            libw.setNombreLibro((String) ll[1]);
            libw.setGenero((String) ll[2]);
            libw.setCategoria((String) ll[3]);
            libw.setDescripcion((String) ll[4]);
            libw.setAutor((String) ll[5]);
            libw.setEditorial((String) ll[6]);
            libw.setUrlPortada((String) ll[7]);
            libw.setIdioma((String) ll[8]);
            libw.setIsbn((String) ll[9]);
            libw.setPaginas((Integer) ll[10]);
            libw.setDigital((BigDecimal)ll[11]);
            libw.setImpreso((BigDecimal)ll[12]);
            libw.setUrlLibro((String) ll[13]);
            reglib.add(libw);
        }
        return reglib;
    }
    
    
}
