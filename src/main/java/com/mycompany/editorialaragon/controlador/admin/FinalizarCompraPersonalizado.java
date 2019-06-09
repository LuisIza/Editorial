/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.CrearLibroCRUD;
import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos;
import com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
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
@WebServlet(name = "FinalizarCompraPersonalizado", urlPatterns = {"/FinalizarCompraPersonalizado"})
public class FinalizarCompraPersonalizado extends HttpServlet {

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
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        
        int paginas = Integer.parseInt(request.getParameter("pag"));
        int cantidad = Integer.parseInt(request.getParameter("can"));
        Date date = new Date();
        PedidosImpresos tmpCompra =(PedidosImpresos) session.getAttribute("Carrito");
        if (tmpCompra.getReferencia().length() <12){
            String ref = MD5.letras();
            String referencia = tmpCompra.getReferencia()+"-"+ref;
            tmpCompra.setReferencia(referencia);
        }
        UsuariosEa user = (UsuariosEa) session.getAttribute("login");
        tmpCompra.setCliente(user.getEmail());
        
        BigDecimal precio = CrearLibroCRUD.showPrecio(tmpCompra.getProducto());
        
        tmpCompra.setCantidad(cantidad);
        tmpCompra.setPaginas(paginas);
        double totpag =0 ;
        
        if (paginas > 50) {
            paginas = paginas - 50;
            totpag = paginas * 0.02;
        }
        double total = (totpag + precio.doubleValue())*cantidad;
        
        tmpCompra.setPrecio(new BigDecimal(totpag + precio.doubleValue()));
        rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
        
        if (session.getAttribute("login")== null){
            session.setAttribute("Carrito", tmpCompra);
            request.setAttribute("accion","Cliente/LoginCliente");
            rd.forward(request, response);
        }else{
            session.setAttribute("Carrito", tmpCompra);
            //request.setAttribute("archivosCarrito", arCliente);
            request.setAttribute("accion","Cliente/FinalizarCompra");
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
