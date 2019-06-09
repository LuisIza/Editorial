/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.datamodel.entidades.*;
import com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa;
import java.io.File;
import java.io.IOException;
import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author WEB1
 */
@WebServlet(name = "GuardarDocumentosCliente", urlPatterns = {"/GuardarDocumentosCliente"})
public class GuardarDocumentosCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final long serialVersionUID = 1L;
    
    private static final String DATA_DIRECTORY = "C:\\Users\\Luis\\Documents\\NetBeansProjects\\EditorialAragon\\src\\main\\webapp\\imprenta";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 * 2;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }
        HttpSession session = request.getSession();
        UsuariosEa user = (UsuariosEa) session.getAttribute("login");

        Date date = new Date();
        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        //String uploadFolder = DATA_DIRECTORY; // Archivos local
        String uploadFolder = getServletContext().getRealPath("") + File.separator + "imprenta"; //Archivos Server

        ServletFileUpload upload = new ServletFileUpload(factory);
        
        PedidosImpresos tmpCompra =(PedidosImpresos) session.getAttribute("Carrito");

            try {
                // Parse the request
                List<FileItem> items = upload.parseRequest(request);
                ArrayList list = new ArrayList();
                    String tipo="";
                for (FileItem item : items) {

                    if (!item.isFormField()) {
                        String nombre = new File(item.getName()).getName();
                        String fileName = String.valueOf(date.getTime() + nombre.replace(" ", ""));
                        String filePath = uploadFolder + File.separator + fileName;
                        File uploadedFile = new File(filePath);
                        list.add(fileName);
                        int i = fileName.lastIndexOf('.');
                        if (i >= 0) {
                            tipo = fileName.substring(i+1);
                        }
                        // saves the file to upload directory
                        item.write(uploadedFile);
                    } else {
                        list.add(new String(item.getString().getBytes(ISO_8859_1), UTF_8));
                    }
                }
                
                tmpCompra.setUrlArchivocliente((String) list.get(0));      
               
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            session.setAttribute("Carrito", tmpCompra);
            request.setAttribute("accion","Cliente/FinalizarCompra");
            rd.forward(request, response);

            } catch (FileUploadException ex) {
                throw new ServletException(ex);
            } catch (Exception ex) {
                throw new ServletException(ex);
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
