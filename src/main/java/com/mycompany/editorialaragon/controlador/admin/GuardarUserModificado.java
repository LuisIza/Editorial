/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;


import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.datamodel.entidades.*;
import com.mycompany.editorialaragon.controlador.CRUD.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

/**
 *
 * @author LUIS
 */
@WebServlet(name = "GuardarUserModificado", urlPatterns = {"/GuardarUserModificado"})
public class GuardarUserModificado extends HttpServlet {

    @Resource
    Validator validador;

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
            throws ServletException, IOException, NamingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        RequestDispatcher rd;
        
      
        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String permisos = request.getParameter("permisos");
      
       
        UsuariosEa us = UserCRUD.findUserEmail(email);

      if (password.equals("")){
          /*Guardar sin contraseña*/
          us.setNombre(nombre);
          us.setEmail(email);
          us.setPermisos(permisos);
          
          UserCRUD.updateUser(us);
          List<UsuariosEa> registros = UserCRUD.showUsuarios();
                rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("registro", registros);
                request.setAttribute("accion", "Admin/gestionIO");
                request.setAttribute("error", "Usuario Modificado correctamente");
                rd.forward(request, response);
      }else{
          /*Guardar todo*/
          String passMD5= MD5.getMD5(password);
          us.setNombre(nombre);
          us.setContrasenya(passMD5);
          us.setEmail(email);
          us.setPermisos(permisos);
          
          UserCRUD.updateUser(us);
          List<UsuariosEa> registros = UserCRUD.showUsuarios();
                rd = request.getRequestDispatcher("index.jsp");
                request.setAttribute("registro", registros);
                request.setAttribute("accion", "Admin/gestionIO");
                request.setAttribute("error", "Usuario Modificado correctamente");
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(GuardarUserModificado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(GuardarUserModificado.class.getName()).log(Level.SEVERE, null, ex);
        }
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
