/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.MD5;
import com.mycompany.editorialaragon.controlador.ObjetoCarrito;
import com.mycompany.editorialaragon.datamodel.entidades.CodigosLibros;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
@WebServlet(name = "BorrarElementoCesta", urlPatterns = {"/BorrarElementoCesta"})
public class BorrarElementoCesta extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        String cesta= request.getParameter("cc");
        String libro = request.getParameter("lib");
        
        HttpSession session = request.getSession();
        List<ObjetoCarrito> listac = (List<ObjetoCarrito>) session.getAttribute("CarritoCompra");
        List<ObjetoCarrito> carrito = new ArrayList();
        if (listac != null){
             
             for(ObjetoCarrito ob : listac){
                 if(ob.getCodigoLibro()!=id){
                     ObjetoCarrito item = new ObjetoCarrito();
                     item.setCodigoLibro(ob.getCodigoLibro());
                     item.setCatidad(ob.getCatidad());
                     item.setNombre(ob.getNombre());
                     item.setTipo(ob.getTipo());
                     item.setPrecio(new BigDecimal(ob.getPrecio().doubleValue()));
                    carrito.add(item);
                 }
             }
            
        } 
        
        CodigosLibros ref = new CodigosLibros();
        String referencia = MD5.letras();
        ref.setReferencia(referencia);
        
      
        RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/Layout.jsp");
        
      
        
        if (session.getAttribute("login")== null){
            if (carrito.isEmpty()){
                session.removeAttribute("CarritoCompra");
                request.setAttribute("ITEM", "Se han eliminado todos los articulos la cesta");
                rd =request.getRequestDispatcher("ServletCompraCreaVende?nom=compra");
                rd.forward(request, response);
            }else if(cesta.equals("menu")&& libro.length()>8){
                session.setAttribute("CarritoCompra", carrito);
                request.setAttribute("ITEM", "Artículo eliminado de la cesta");
                rd =request.getRequestDispatcher("ServletCompraCreaVende?nom=compra");
                rd.forward(request, response);
            }else if(libro.length()<8){
                session.setAttribute("CarritoCompra", carrito);
                request.setAttribute("ITEM", "Artículo eliminado de la cesta");
                rd =request.getRequestDispatcher("BotonInfoLibroComprar?id="+libro);
                rd.forward(request, response);
            }else{
            session.setAttribute("REF", ref);
            session.setAttribute("CCD", "ccd");
            request.setAttribute("accion","Cliente/LoginCliente");
            rd.forward(request, response);
            }
            
        }else{
            if(carrito.isEmpty()){
                session.removeAttribute("CarritoCompra");
                request.setAttribute("ITEM", "Se han eliminado todos los articulos la cesta");
                rd =request.getRequestDispatcher("ServletCompraCreaVende?nom=compra");
                rd.forward(request, response);
            }else if(cesta.equals("menu")&& libro.length()>8){
                session.setAttribute("CarritoCompra", carrito);
                request.setAttribute("ITEM", "Artículo eliminado de la cesta");
                rd =request.getRequestDispatcher("BotonInfoLibroComprar?id="+libro);
                rd.forward(request, response);
            }else if(libro.length()<8){
                session.setAttribute("CarritoCompra", carrito);
                request.setAttribute("ITEM", "Artículo eliminado de la cesta");
                rd =request.getRequestDispatcher("BotonInfoLibroComprar?id="+libro);
                rd.forward(request, response);
            }else{
            session.setAttribute("CarritoCompra", carrito);
            session.setAttribute("REF", ref);
            request.setAttribute("accion","Cliente/CarritoLibros");
            rd.forward(request, response); 
            }
            
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
