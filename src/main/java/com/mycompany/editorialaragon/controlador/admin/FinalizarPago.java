/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.CodigoLibrosCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.DatosUserCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.HistorialCompraCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.controlador.ObjetoCarrito;
import com.mycompany.editorialaragon.datamodel.entidades.CodigosLibros;
import com.mycompany.editorialaragon.datamodel.entidades.DatosUsuarioEa;
import com.mycompany.editorialaragon.datamodel.entidades.HistorialCompras;
import com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa;
import com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
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
@WebServlet(name = "FinalizarPago", urlPatterns = {"/FinalizarPago"})
public class FinalizarPago extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        HttpSession session = request.getSession();
        List<ObjetoCarrito> carrito = (List<ObjetoCarrito>) session.getAttribute("CarritoCompra");
        UsuariosEa user = (UsuariosEa) session.getAttribute("login");
        CodigosLibros ref = (CodigosLibros) session.getAttribute("REF");
        Date date = new Date();
        
        String codigo1 = MD5.letras();
        String codigo2 = MD5.letras();
       
        
        CodigosLibros codLib = new CodigosLibros();
        codLib.setReferencia(ref.getReferencia());
        codLib.setCodigo(codigo1+"-"+codigo2);
        codLib.setFechaInicio(date);
        codLib.setFechaFin(date);
        CodigoLibrosCRUD.create(codLib);
        
        DatosUsuarioEa datos= new DatosUsuarioEa();
        datos.setNombre(nombre);
        datos.setApellidos(apellidos);
        datos.setEmail(email);
        datos.setTelefono(telefono);
        datos.setCliente(user);
        DatosUserCRUD.create(datos);//crear datos de usuario
        
        double total;
        LibroPublicadoEa libro;
        for (ObjetoCarrito ob : carrito){
           HistorialCompras hc = new HistorialCompras();
           hc.setReferencia(ref.getReferencia());
           hc.setCliente(user);
           libro = LibroCRUD.showLibro(ob.getCodigoLibro());
           hc.setProductoId(libro);
           hc.setFecha(date);
           hc.setPrecioBase(new BigDecimal(ob.getPrecio().doubleValue()));
           hc.setCantidad(ob.getCatidad());
           hc.setIvaBase(new BigDecimal(1));
           total = ob.getCatidad() * ob.getPrecio().doubleValue();
           hc.setPrecioTotal(new BigDecimal(total));
           hc.setEstado("Pendiente");
           
           HistorialCompraCRUD.create(hc);
             
        }
        
        RequestDispatcher rdr = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            session.removeAttribute("CarritoCompra");
            request.setAttribute("REFF", ref.getReferencia());
            request.setAttribute("accion","Cliente/CompraFinalizadaLibros");
            rdr.forward(request, response);
        
        
        
        if(carrito != null && user != null ){
            
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
