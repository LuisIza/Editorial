/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.GenerosREAD;
import com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD;
import com.mycompany.editorialaragon.datamodel.entidades.CategoriasLibrosEa;
import com.mycompany.editorialaragon.datamodel.entidades.GenerosEa;
import com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa;
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
@WebServlet(name = "GuardarDatosLibro", urlPatterns = {"/GuardarDatosLibro"})
public class GuardarDatosLibro extends HttpServlet {

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

        String nombreLibro = request.getParameter("nombre");
        int idG =Integer.parseInt(request.getParameter("genero"));
        int idC =Integer.parseInt(request.getParameter("categoria"));
        String autor = request.getParameter("autor");
        String editorial = request.getParameter("editorial");
        String isbn = request.getParameter("isbn");
        String idioma = request.getParameter("idioma");
        String paginas = request.getParameter("paginas");
        String chkimpreso = request.getParameter("impreso");
        String chkdigital = request.getParameter("digital");
        String impreso = request.getParameter("precioImpreso");
        String digital = request.getParameter("precioDigital");
        String descripcion = request.getParameter("descripcion");
        
        GenerosEa gen=GenerosREAD.showGenero(idG);
        String genero = gen.getGenero();
        CategoriasLibrosEa cat = GenerosREAD.showCategoria(idC);
        String categoria = cat.getCategoria();
        Date date=new Date();
       
       HttpSession session = request.getSession();
       LibroPublicadoEa libro = new LibroPublicadoEa();
       UsuariosEa user = (UsuariosEa) session.getAttribute("login");
       
        libro.setNombreLibro(nombreLibro);
        libro.setAutor(autor);
        libro.setGenero(genero);
        libro.setCategoria(categoria);
        libro.setEditorial(editorial);
        libro.setIsbn(isbn);
        libro.setIdioma(idioma);
        libro.setPaginas(Integer.parseInt(paginas));
        if (chkimpreso != null){
            double pre = Double.parseDouble(impreso);
            libro.setImpreso(BigDecimal.valueOf(pre));
        }else{
            libro.setImpreso(new BigDecimal(-5));
        }
        if (chkdigital != null){
            double pre = Double.parseDouble(digital);
            libro.setDigital(BigDecimal.valueOf(pre));
        }else{
            libro.setDigital(new BigDecimal(-5));
        }
        libro.setEmail(user); /*user q crea*/
        libro.setEstado("oculto");
        libro.setDescripcion(descripcion);
        libro.setFechaAlta(date);
        libro.setPermanencia("si");/*Permamencia siempre*/
        
        //LibroCRUD.updateLibro(libro);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            session.setAttribute("NuevoLibro",libro);
            //request.setAttribute("Mostrar", libro);
            request.setAttribute("accion","Admin/PortadaLibro");
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
