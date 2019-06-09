/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.ArchivosCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.Comprobaciones;
import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.datamodel.entidades.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author WEB1
 */
@WebServlet(name = "BorrarLibroCompleto", urlPatterns = {"/BorrarLibroCompleto"})
public class BorrarLibroCompleto extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
         
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        
        LibroPublicadoEa libro = LibroCRUD.showLibro(id);
        
       File fichero = new File(getServletContext().getRealPath("") + File.separator + "upload"+File.separator + libro.getUrlPortada()); // archivo servidor
        //File fichero = new File("C:\\Users\\WEB1\\Documents\\NetBeansProjects\\EditorialAragon\\src\\main\\webapp\\upload\\" + libro.getUrlPortada());// archivo local
        
        Comprobaciones.BorrarFichero(fichero);

        List <ArchivosLibroEa> ar = ArchivosCRUD.showArchivos(libro.getId());
        
        if (ar == null || ar.isEmpty()){
            
        }else{
            for ( ArchivosLibroEa a : ar){
                fichero = new File(getServletContext().getRealPath("") + File.separator + "upload"+File.separator + a.getUrlArchivo()); // Archivo servidor
                //fichero = new File("C:\\Users\\WEB1\\Documents\\NetBeansProjects\\EditorialAragon\\src\\main\\webapp\\upload\\" + a.getUrlArchivo()); // Archivo local
                Comprobaciones.BorrarFichero(fichero);
            }
            
        }
        LibroCRUD.deleteLibro(libro);
        RequestDispatcher rd = request.getRequestDispatcher("IndexServlet");
        rd.include(request, response);
         
     /*   List <PublicidadEa> registross = LibroCRUD.showLibros(id);
                    request.setAttribute("libros", registross);
                    request.setAttribute("accion","gestionLibros");
                    rd.forward(request, response);*/
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
