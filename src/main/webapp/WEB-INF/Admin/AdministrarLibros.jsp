<%-- 
    Document   : gestionIO
    Created on : 15-dic-2018, 20:36:49
    Author     : LUIS
--%>


<%@page import="java.util.Date"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.*"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<!--<div class="row black">
    <div class="col l4 m4 s4 tabLibros hoverable"> <span>Libros Publicados</span></div>
    <div class="col l4 m4 s4 tabLibros hoverable"> <span>Pendientes Publicación</span></div>
    <div class="col l4 m4 s4 tabLibros hoverable"><span>Libros Ocultos</span></div>
    <b>
          
    </b>

</div>-->
<%List<LibroPublicadoEa> libros = (List<LibroPublicadoEa>) request.getAttribute("libros");
            Thread.sleep(1500);%>

 <br> <br>
<div class="row">
    <% if (libros == null || libros.isEmpty()) {%>
    <div class="col s10 offset-s1">
        <div class="card hoverable">
            <br>
            <h3 class="center-align">No hay ninguna solicitud de publicación....</h3><br>
        </div>
    </div>

    <%} else {%>

    <div class="col l10 offset-l1">
        <div class="card">
        
        <div class="card-content">
        
            <h3 class="center-align">Listado Solicitudes de publicación </h3><br>
        <table class="striped responsive-table">
        <thead>
          <tr>
              <th>Publicador</th>
              <th>Nombre del libro</th>
              <th>Fecha de solicitud</th>
              <th >Abrir</th>
          </tr>
        </thead>

        <tbody>
            
        <%for (LibroPublicadoEa p : libros) {%>  
     
        <tr class="hoverable">
            <td class="center-align"> <%=p.getId()%>  </td> 
                  <td><%=p.getNombreLibro()%></td>
                  <td><%=(Date) p.getFechaAlta()%></td>
                
                  <td>
                   
                        <a class="btn-floating blue-grey darken-1" href="BotonInfoLibro?id=<%=p.getId()%>"><i class="material-icons">library_books</i>Ver o Modificar libro</a> 
                   
                  </td>
         
         </tr>
         
            <%}%>
            
            
            
          
           
         
    
        </tbody>
      </table>
        </div></div>


    
              <% }%>


    </div>

</div>

<p>&nbsp;</p> 
<p>&nbsp;</p>

