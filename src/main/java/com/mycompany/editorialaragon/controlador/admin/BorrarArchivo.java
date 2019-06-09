/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.ArchivosCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.Comprobaciones;
import com.mycompany.editorialaragon.datamodel.entidades.ArchivosLibroEa;
import com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa;
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
@WebServlet(name = "BorrarArchivo", urlPatterns = {"/BorrarArchivo"})
public class BorrarArchivo extends HttpServlet {

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
       
        String idtxt = request.getParameter("id");
        int id = Integer.parseInt(idtxt);
        HttpSession session = request.getSession();
        
        LibroPublicadoEa libro = (LibroPublicadoEa) session.getAttribute("NuevoLibro");
        ArchivosLibroEa ar = ArchivosCRUD.showArchivo(id);
       
        File fichero = new File(getServletContext().getRealPath("") + File.separator + "upload"+File.separator +ar.getUrlArchivo()); // Archivo server
        //File fichero = new File("C:\\Users\\WEB1\\Documents\\NetBeansProjects\\EditorialAragon\\src\\main\\webapp\\upload\\" + ar.getUrlArchivo()); // Archivo local
        
        if (fichero.exists()) {
            Comprobaciones.BorrarFichero(fichero);/*borrar archivo*/
            ArchivosCRUD.deleteArchivo(ar);
            List <ArchivosLibroEa> listaArchivos = ArchivosCRUD.showArchivos(libro.getId());
        
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            session.setAttribute("NuevoLibro",libro);
            request.setAttribute("Mostrar", libro);
            request.setAttribute("archivos", listaArchivos);
            request.setAttribute("accion","Admin/InfoLibro");
            rd.forward(request, response);
        }else{
            ArchivosCRUD.deleteArchivo(ar);
            List <ArchivosLibroEa> listaArchivos = ArchivosCRUD.showArchivos(libro.getId());
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            session.setAttribute("NuevoLibro",libro);
            request.setAttribute("Mostrar", libro);
            request.setAttribute("archivos", listaArchivos);
            request.setAttribute("accion","Admin/InfoLibro");
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
