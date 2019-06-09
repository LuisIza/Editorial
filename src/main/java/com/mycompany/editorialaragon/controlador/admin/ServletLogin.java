/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.*;
import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.datamodel.entidades.*;
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
 * @author LUIS
 */
@WebServlet(name = "ServletLogin", urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {

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
        
            String nombre = request.getParameter("nombre");
            String passw = request.getParameter("password");
            String tipo = request.getParameter("tipo");
         
            RequestDispatcher rd;
            HttpSession session = request.getSession();
            Boolean findUser = UserCRUD.userExiste(nombre);
            
            if (findUser){
                String passMD5 = MD5.getMD5(passw);
                Boolean passOk = UserCRUD.userOkPass(nombre, passMD5);
                UsuariosEa usLog = UserCRUD.findUserEmail(nombre);
                
                
                if(passOk){
                   
                   if (usLog.getPermisos().equals("Administrador")) {
                       List<LibroPublicadoEa>lista = LibroCRUD.librosAutorizacion();
                     
                        rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                        List<UsuariosEa> registros = UserCRUD.showUsuarios();
                        request.setAttribute("notificacion", lista);
                        request.setAttribute("registro", registros);
                        session.setAttribute("login",usLog);
                        request.setAttribute("accion","Admin/gestionIO");
                        rd.forward(request, response);
                   }else  if (usLog.getPermisos().equals("Publicador")){
                       rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                        List <LibroPublicadoEa> registross = LibroCRUD.showLibros(nombre);
                        request.setAttribute("libros", registross);
                        session.setAttribute("login",usLog);
                        request.setAttribute("accion","Admin/gestionLibros");
                        rd.forward(request, response);
                   }else{
                        rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                       if(session.getAttribute("Carrito")!= null){
                           request.setAttribute("accion","Cliente/DetallesCompra");
                           session.setAttribute("login",usLog);
                           rd.forward(request, response);
                       }
                       if(session.getAttribute("CCD")!= null){
                           request.setAttribute("accion","Cliente/CarritoLibros");
                           session.setAttribute("login",usLog);
                           rd.forward(request, response);
                           
                       }
                        session.setAttribute("login",usLog);
                        request.setAttribute("accion","home");
                        rd.forward(request, response);
                   }
                }else{
                    if (tipo.equals("adm")){
                        rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                        request.setAttribute("accion","Admin/LoginAdmin");
                        request.setAttribute("error", "Contraseña incorrecta");
                        rd.forward(request, response);
                    }
                        
                    rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                        request.setAttribute("accion","Cliente/LoginCliente");
                        request.setAttribute("error", "Contraseña incorrecta");
                        rd.forward(request, response);
                }
            }else{
                if (tipo.equals("adm")){
                    rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                    request.setAttribute("accion","Admin/LoginAdmin");
                    request.setAttribute("error", "Usuario no Registrado");
                    rd.forward(request, response);
                }
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                request.setAttribute("accion","Cliente/LoginCliente");
                request.setAttribute("error", "Usuario no Registrado");
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
