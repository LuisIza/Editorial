/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.ArchivosCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.SuscriptorCRUD;
import com.mycompany.editorialaragon.controlador.SendMail;
import com.mycompany.editorialaragon.datamodel.entidades.ArchivosLibroEa;
import com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa;
import com.mycompany.editorialaragon.datamodel.entidades.SuscriptoresEa;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
@WebServlet(name = "LibroGratis", urlPatterns = {"/LibroGratis"})
public class LibroGratis extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        //String terminos = request.getParameter("terminos");
        Date date=new Date();
        
        
        SuscriptoresEa nuevo = new SuscriptoresEa();
        nuevo.setEmail(email);
        nuevo.setEstado("alta");
        nuevo.setFechaAlta(date);
        nuevo.setLibro(id);
        nuevo.setNombre(nombre);
        
        LibroPublicadoEa lib = LibroCRUD.showLibro(id);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
        if (lib != null){
          List <ArchivosLibroEa> arc = ArchivosCRUD.showArchivos(lib.getId());
          if (arc != null){
              String ruta= request.getContextPath()+"/upload/"+arc.get(0).getUrlArchivo();
              String msg = "Enviamos Link de descarga del libro\n"
                      +  ruta +
                      "\n Gracias por utilizar nuestros servicios.";
            SendMail.Enviar(lib.getNombreLibro(), msg, nombre, email);
            SuscriptorCRUD.create(nuevo); 
            request.setAttribute("mail","enviado");
          }
          request.setAttribute("accion","ComprarLibro");
          rd.forward(request, response);
          
        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
