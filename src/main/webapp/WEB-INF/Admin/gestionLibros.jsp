<%-- 
    Document   : gestionIO
    Created on : 15-dic-2018, 20:36:49
    Author     : LUIS
--%>
 

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.*"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<br> <br> 
 
        <%List<LibroPublicadoEa> libros = (List<LibroPublicadoEa>) request.getAttribute("libros"); 
        Thread.sleep(1000);%>
       
          
  <div class="row">
            <% if (libros == null || libros.isEmpty()){%>
               <div class="col s10 offset-s1">
  		<div class="card hoverable">
                <h3>No hay ningun libro....</h3>
                </div>
             </div>

            <%}else{%>
            
      <div class="col l12">
          
          
            <%for (LibroPublicadoEa p : libros){%>
          <a href="BotonInfoLibro?id=<%=p.getId()%>">
            <div class="col l2  m4  s6">
                  <div class="card hoverable">
                      <div class="card-image">
                          <img src="<%=request.getContextPath()%>/upload/<%=p.getUrlPortada()%>">
                          <span class="titulocursos"><%=p.getNombreLibro()%></span>
                      </div>

                         <!-- <div class="card-content">
                              <p><%--=texto--%></p>
                          </div>-->
                          <div class="card-action">
                              <a href="BotonInfoLibro?id=<%=p.getId()%>">Leer más...</a> 
                          </div>
                   </div>
            </div> </a>
           <%} }%>
          
           	
      </div>
      
  </div>
       
        <p>&nbsp;</p> 
        <p>&nbsp;</p>
         
