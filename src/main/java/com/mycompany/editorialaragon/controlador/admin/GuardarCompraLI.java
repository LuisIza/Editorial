/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.editorialaragon.controlador.admin;

import com.mycompany.editorialaragon.controlador.CRUD.DatosUserCRUD;
import com.mycompany.editorialaragon.controlador.CRUD.PedidosImpresosCRUD;
import com.mycompany.editorialaragon.controlador.SendMail;
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
@WebServlet(name = "GuardarCompraLI", urlPatterns = {"/GuardarCompraLI"})
public class GuardarCompraLI extends HttpServlet {

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
        
        if (session.getAttribute("LI")!= null){
            RequestDispatcher rdr = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            request.setAttribute("accion","Cliente/CompraRealizada");
            rdr.forward(request, response);
        }else{
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
            tmpCompra.setFechaAlta(date);
            tmpCompra.setEstado("Pendiente");
            tmpCompra.setUrlArchivocliente((String) list.get(0)); 
            PedidosImpresosCRUD.create(tmpCompra);
            
            DatosUsuarioEa datos= new DatosUsuarioEa();
            datos.setNombre((String) list.get(1));
            datos.setApellidos((String) list.get(2));
            datos.setCliente(user);
            datos.setEmail((String) list.get(3));
            datos.setTelefono((String) list.get(4));
            datos.setPais((String) list.get(5));
            datos.setPoblacion((String) list.get(6));
            datos.setCp((String) list.get(7));
            datos.setDireccion((String) list.get(8) +"# "+(String) list.get(9) + ", " + (String) list.get(10));
            DatosUserCRUD.create(datos);
            
            int cantidad =tmpCompra.getCantidad();
            
            double precio = tmpCompra.getPrecio().doubleValue();
          
            double total = precio*cantidad;
            
            String subj = "Información de pago";
            String txt= "Gracias por utilizar nuestro servico.\n"
                    + "La modalidad de pago es por transferencia a la siguiente cuenta:\n ES15 2546 5878 7854 2100\n"
                    + "Concepto especificar la siguiente referencia: "+ tmpCompra.getReferencia()+
                    "\n Importe de la transferencia: " + total +" €"+
                    "\n Una vez verificada la transferencia se procedera a la creacion y el envio del producto \n";
                SendMail.Enviar(subj, txt, datos.getNombre(), datos.getEmail());
            
            RequestDispatcher rdr = request.getRequestDispatcher("/WEB-INF/Layout.jsp");
            session.setAttribute("LI", "ok");
            session.setAttribute("Carrito", tmpCompra);
            request.setAttribute("accion","Cliente/CompraRealizada");
           
            rdr.forward(request, response);
          
            } catch (FileUploadException ex) {
                throw new ServletException(ex);
            } catch (Exception ex) {
                throw new ServletException(ex);
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
