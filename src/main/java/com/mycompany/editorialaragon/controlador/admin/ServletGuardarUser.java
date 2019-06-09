/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

//import com.mycompany.editorialaragon.EJB.EJBUsuarioLocal;
import com.mycompany.editorialaragon.EJB.*;
import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.datamodel.entidades.*;
import com.mycompany.editorialaragon.controlador.CRUD.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author LUIS
 */
@WebServlet(name = "ServletGuardarUser", urlPatterns = {"/ServletGuardarUser"})
public class ServletGuardarUser extends HttpServlet {

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
        HttpSession session = request.getSession();
        RequestDispatcher rd;

        String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String permisos = request.getParameter("permisos");
        Date fecha = new Date();

        UsuariosEa login = (UsuariosEa) session.getAttribute("login");

        if (session.getAttribute("reenvio") == null) {

            EJBUsuarioLocal bean = (EJBUsuarioLocal) new InitialContext().lookup("java:module/EJBUsuario");
            bean.setUsuario(nombre);
            bean.setPassword(password);
            bean.setEmail(email);

            for (ConstraintViolation c : validador.validate(bean)) {
                c.getMessage();
            }

            if (validador.validate(bean).isEmpty()) {

                String passMD5 = MD5.getMD5(password);
                UsuariosEa user = UserCRUD.findUserEmail(email);

                if (user == null) {

                    UsuariosEa nuevoUsuario = new UsuariosEa();
                    nuevoUsuario.setNombre(nombre);
                    nuevoUsuario.setEmail(email);
                    nuevoUsuario.setContrasenya(passMD5);
                    nuevoUsuario.setPermisos(permisos);
                    nuevoUsuario.setFechaAlta(fecha);
                    UserCRUD.create(nuevoUsuario);
                    rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                    
                    if (login != null){
                        if (login.getPermisos().equals("Administrador")) {
                            request.setAttribute("error", "Usuario Guardado correctamente");
                            session.setAttribute("reenvio", "ok");
                            rd.forward(request, response);
                        }
                    }
                    
                    if (permisos.equals("Publicador")) {
                        request.setAttribute("accion", "Admin/LoginAdmin");
                        request.setAttribute("error", "Usuario Guardado correctamente");
                        session.setAttribute("reenvio", "ok");
                        rd.forward(request, response);
                    }
                    if (permisos.equals("Cliente")) {
                        request.setAttribute("accion", "Cliente/LoginCliente");
                        request.setAttribute("error", "Usuario Guardado correctamente");
                        session.setAttribute("reenvio", "ok");
                        rd.forward(request, response);
                    }
                     

                } else {
                    rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                    if (login.getPermisos().equals("Administrador")) {
                        request.setAttribute("accion", "Admin/AltaUser");
                        request.setAttribute("error", "Datos incorrectos Usuario ya existe");
                        rd.forward(request, response);
                    }
                    if (permisos.equals("Publicador")) {
                        request.setAttribute("accion", "Admin/FormRegistro");
                        request.setAttribute("error", "Datos incorrectos Usuario ya existe");
                        rd.forward(request, response);
                    }
                    if (permisos.equals("Cliente")) {
                        request.setAttribute("accion", "Cliente/FormRegistroCliente");
                        request.setAttribute("error", "Datos incorrectos Usuario ya existe");
                        rd.forward(request, response);
                    }
                }

            } else {
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                if (login.getPermisos().equals("Administrador")) {
                    request.setAttribute("accion", "Admin/AltaUser");
                    request.setAttribute("error", "Formato de Email o contraseña incorrecto");
                    rd.forward(request, response);
                }
                if (permisos.equals("Publicador")) {
                    request.setAttribute("accion", "Admin/FormRegistro");
                    request.setAttribute("error", "Formato de Email o contraseña incorrecto");
                    rd.forward(request, response);
                }
                if (permisos.equals("Cliente")) {
                    request.setAttribute("accion", "Cliente/FormRegistroCliente");
                    request.setAttribute("error", "Formato de Email o contraseña incorrecto");
                    rd.forward(request, response);
                }

            }

        } else {
            rd = request.getRequestDispatcher("ControladorBotones?nom=iniciar");
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
            Logger.getLogger(ServletGuardarUser.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletGuardarUser.class.getName()).log(Level.SEVERE, null, ex);
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
