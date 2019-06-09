/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.Comprobaciones;
import com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Luis
 */
@WebServlet(name = "CancelarImpresion", urlPatterns = {"/CancelarImpresion"})
public class CancelarImpresion extends HttpServlet {

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
          HttpSession session = request.getSession();
          PedidosImpresos tmpCompra =(PedidosImpresos) session.getAttribute("Carrito");
           //File fichero = new File(getServletContext().getRealPath("") + File.separator + "imprenta"+File.separator +ar.getUrlArchivo()); // Archivo server
          File fichero = new File("C:\\Users\\WEB1\\Documents\\NetBeansProjects\\EditorialAragon\\src\\main\\webapp\\imprenta\\" + tmpCompra.getUrlArchivocliente()); // Archivo local
        Comprobaciones.BorrarFichero(fichero);
        if (fichero.exists()) {
            Comprobaciones.BorrarFichero(fichero);/*borrar archivo*/
        }
        
        tmpCompra.setUrlArchivocliente("");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");    
            session.setAttribute("Carrito", tmpCompra);
           
            request.setAttribute("accion","Cliente/CrearLibro");
            rd.forward(request, response);
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
