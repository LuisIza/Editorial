/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador;
import com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa;
import java.io.IOException;
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
@WebServlet(name = "ServletCompraCreaVende", urlPatterns = {"/ServletCompraCreaVende"})
public class ServletCompraCreaVende extends HttpServlet {

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
        
        String accion = request.getParameter("nom");
        UsuariosEa login = (UsuariosEa) session.getAttribute("login");
       
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
        /*************************/
        if (session.getAttribute("login")== null || login.getPermisos().equals("Cliente")){
            if (accion.equals("compra")){
                request.setAttribute("accion","ComprarLibro");
                rd.forward(request, response);
            }
            if (accion.equals("vende")){
                request.setAttribute("accion","ComprarLibro");
                rd.forward(request, response);
            }
            if (accion.equals("crear")){
                request.setAttribute("accion","Cliente/CrearLibro");
                rd.forward(request, response);
            }
            if (accion.equals("crearLibro")){
                request.setAttribute("accion","Cliente/CrearLibro");
                rd.forward(request, response);
            }
        }else{
            request.setAttribute("accion","home");
            rd.forward(request, response);
        }
       
       /********************************************/
       
       
     
       
       
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
