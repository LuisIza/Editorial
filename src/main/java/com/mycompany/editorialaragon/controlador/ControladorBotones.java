/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador;
import com.mycompany.editorialaragon.controlador.CRUD.HistorialCompraCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.PedidosImpresosCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.UserCRUD;
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
 * @author Luis
 */
@WebServlet(name = "ControladorBotones", urlPatterns = {"/ControladorBotones"})
public class ControladorBotones extends HttpServlet {

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
        
        String accion = request.getParameter("nom");
        HttpSession session = request.getSession();
        RequestDispatcher rd;
        
        /****CERRAR SESION*****/
        if (accion.equals("salir")){
            session.invalidate();
            rd = request.getRequestDispatcher("IndexServlet");
            rd.forward(request, response);
        }
        
        if (session.getAttribute("cliente")== null && session.getAttribute("login")== null){
            if (accion.equals("iniciar")){
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                request.setAttribute("accion","IniciarSesion");
                rd.forward(request, response);
            }
            if (accion.equals("colaborador")){
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                request.setAttribute("accion","Admin/LoginAdmin");
                rd.forward(request, response);
            }
            if (accion.equals("cuentadmin")){
                session.removeAttribute("reenvio");
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                request.setAttribute("accion","Admin/FormRegistro");
                rd.forward(request, response);
            }
            if (accion.equals("cliente")){
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                request.setAttribute("accion","Cliente/LoginCliente");
                rd.forward(request, response);
            }
            
              if (accion.equals("cuentacliente")){
                session.removeAttribute("reenvio");
                rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                request.setAttribute("accion","Cliente/FromRegistroCliente");
                rd.forward(request, response);
            }
            
            
            
        }else if(session.getAttribute("login")!= null){
           UsuariosEa login = (UsuariosEa) session.getAttribute("login");
                 
                   if (login.getPermisos().equals("Administrador")) {
                        List<LibroPublicadoEa>lista = LibroCRUD.librosAutorizacion();
        
                        rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                        if (accion.equals("nuevoUser")){
                            request.setAttribute("notificacion", lista);
                            session.removeAttribute("reenvio");
                            request.setAttribute("accion","Admin/AltaUser");
                            rd.forward(request, response);
                        } else if (accion.equals("administrar")){
                            request.setAttribute("notificacion", lista);
                            session.removeAttribute("reenvioLibro");
                            request.setAttribute("libros", lista);
                            request.setAttribute("accion","Admin/AdministrarLibros");
                            rd.forward(request, response);
                        }else{
                            request.setAttribute("notificacion", lista);
                            session.removeAttribute("reenvioLibro");
                            List<UsuariosEa> registros = UserCRUD.showUsuarios();
                            request.setAttribute("registro", registros);
                            request.setAttribute("accion","Admin/gestionUsuarios");
                            rd.forward(request, response);
                        }
                        
                   }else  if (login.getPermisos().equals("Publicador")){
                       rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                       if (accion.equals("nuevoLibro")){
                           session.removeAttribute("reenvioLibro");
                            request.setAttribute("accion","Admin/DatosLibro");
                            rd.forward(request, response);
                        }
                   } else{
                       rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
                       if (accion.equals("creaciones")){
                           List<PedidosImpresos> pedidos = PedidosImpresosCRUD.showPedidos(login.getEmail());
                            session.removeAttribute("reenvioLibro");
                            request.setAttribute("creacion", pedidos);
                            request.setAttribute("accion","Admin/MisCreaciones");
                            rd.forward(request, response);
                        }else{
                           List<HistorialCompras> his = HistorialCompraCRUD.showHistorial(login.getEmail());
                           session.removeAttribute("reenvioLibro");
                           request.setAttribute("historial", his);
                            request.setAttribute("accion","Admin/HistorialPedidos");
                            rd.forward(request, response);
                       }
                       
                   }
 
        }else{
            rd = request.getRequestDispatcher("IndexServlet");
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
