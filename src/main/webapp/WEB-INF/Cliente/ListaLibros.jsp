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
<br> <br><br> <br><br>
 
        <%List<LibroPublicadoEa> libros = (List<LibroPublicadoEa>) request.getAttribute("libros"); 
        Thread.sleep(1500);%>
       
          
  <div class="row">

      <div class="col l10 offset-l1">
          
          <% if (libros == null || libros.isEmpty()){%>
               <div class="col l4  m6  s12">
  		<div class="card hoverable">
                <h3>No hay ningun libro....</h3>
                </div>
             </div>

            <%}else{
            for (LibroPublicadoEa p : libros){
            String texto = p.getDescripcion();
            if (texto.length()>200){
            texto = texto.substring(0, 200);
            }%>
          
            <div class="col l4  m6  s12">
                  <div class="card hoverable">
                      <div class="card-image">
                          <img src="<%=request.getContextPath()%>/upload/<%=p.getUrlPortada()%>">
                          <span class="titulocursos"><%=p.getNombreLibro()%></span>
                      </div>

                          <div class="card-content">
                              <p><%=texto%>......</p>
                          </div>
                          <div class="card-action">
                              <a href="BotonInfoLibro?id=<%=p.getId()%>" >Leer más...</a> 
                          </div>
                   </div>
            </div> 
           <%} }%>
          
           	
      </div>
      
  </div>
       
        <p>&nbsp;</p> 
        <p>&nbsp;</p>
         
