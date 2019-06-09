/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador;

import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddArticuloCesta", urlPatterns = {"/AddArticuloCesta"})
public class AddArticuloCesta extends HttpServlet {

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
        //RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
        HttpSession session = request.getSession();
        List<ObjetoCarrito> carrito;
        ObjetoCarrito item;
        session.removeAttribute("LI");
        int idLibro = Integer.parseInt(request.getParameter("id"));
        int cantidad = 1;
        String tipo = request.getParameter("tipo");
        LibroPublicadoEa libro = LibroCRUD.showLibro(idLibro);
        carrito = (List<ObjetoCarrito>) session.getAttribute("CarritoCompra");
        String mensaje = "";
        Boolean repetido = true;

        if (carrito == null) {
            carrito = new ArrayList();
            if (libro != null) {
                item = new ObjetoCarrito();
                item.setCodigoLibro(idLibro);
                item.setNombre(libro.getNombreLibro());
                item.setCatidad(cantidad);
                if (tipo.equals("D")) {
                    item.setTipo("Digital");
                    item.setPrecio(libro.getDigital());
                } else {
                    item.setTipo("Tapa dura");
                    item.setPrecio(libro.getImpreso());
                }
                carrito.add(item);
            }
        } else {
            for (ObjetoCarrito c : carrito) {
                if (c.getCodigoLibro() == idLibro) {
                    repetido = false;
                }
            }
            if (libro != null) {
                item = new ObjetoCarrito();
                if (repetido) {
                    item.setCodigoLibro(idLibro);
                    item.setNombre(libro.getNombreLibro());
                    item.setCatidad(cantidad);
                    if (tipo.equals("D")) {
                        item.setTipo("Digital");
                        item.setPrecio(libro.getDigital());
                    } else {
                        item.setTipo("Tapa dura");
                        item.setPrecio(libro.getImpreso());
                    }
                    carrito.add(item);
                    mensaje = "Artículo añadido correctamente";
                } else {
                    mensaje = "Este artícuo ya está en la cesta";
                }

            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
        
        if (libro != null) {
            session.setAttribute("CarritoCompra", carrito);
            //session.setAttribute("NuevoLibro",libro);
            request.setAttribute("accion", "InfoLibro");
            request.setAttribute("Mostrar", libro);
            request.setAttribute("ITEM", mensaje);
            request.setAttribute("accion", "InfoLibro");
            rd.forward(request, response);

        } else {
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
