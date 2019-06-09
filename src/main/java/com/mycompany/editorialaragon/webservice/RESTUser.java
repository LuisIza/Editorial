/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.webservice;

import com.mycompany.editorialaragon.controlador.CRUD.GenerosREAD;
import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.UserCRUD;
import com.mycompany.editorialaragon.datamodel.entidades.CategoriasLibrosEa;
import com.mycompany.editorialaragon.webservice.datos.*;
import com.mycompany.editorialaragon.webservice.datos.LibroCliente;
import com.mycompany.editorialaragon.webservice.datos.LibroVenta;
import com.mycompany.editorialaragon.webservice.datos.ListaLibros;
import com.mycompany.editorialaragon.webservice.datos.ListaLibrosVenta;
import com.mycompany.editorialaragon.webservice.datos.UsLDB;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Luis
 */
@Path("/user")
public class RESTUser {
    
   @POST
   @Path("/login")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public UsLDB respuestaLog (InUser us){  
      List<?> userL;
      userL = null;
      String msn="Email o contraseña incorrectos";
      boolean userok = UserCRUD.userOkPass(us.getMail(), us.getPass());
      if (userok){
        userL = UserCRUD.findUserRest(us.getMail()); 
        msn="Login OK";
      }
       return  new UsLDB(msn, userok, userL);
    }
    
   @POST
   @Path("/libros")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public ListaLibros listarLibro (InUser us){  
      
      boolean confirm= false;
      boolean userok = UserCRUD.userOkPass(us.getMail(), us.getPass());
     
      List<LibroCliente> lib;
      lib = null;
      if (userok){
      
        lib = LibroCRUD.LibrosPub(us.getMail());
        confirm = true;
      }
      ListaLibros respuesta = new ListaLibros(lib, confirm);
      return respuesta;
      }
    
   @POST
   @Path("/librosVenta")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public ListaLibrosVenta librosVenta (Categorias id){  

      boolean confirm= false;
      List<LibroVenta> lib;
      lib = LibroCRUD.LibrosVenta(id.getId());
      if (lib != null){
          confirm = true;
      }
      ListaLibrosVenta respuesta = new ListaLibrosVenta(lib, confirm);
      return respuesta;
  
    }
   
   @POST
   @Path("/categorias")
   @Produces(MediaType.APPLICATION_JSON)
   @Consumes(MediaType.APPLICATION_JSON)
   public List<CategoriasLibrosEa> listaCategorias (Categorias id){  

      List<CategoriasLibrosEa> cat = GenerosREAD.showCategorias(id.getId());
      return cat;
     
    }
 
}