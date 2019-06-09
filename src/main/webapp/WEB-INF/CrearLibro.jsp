<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
  <% UsuariosEa login = (UsuariosEa) session.getAttribute("login");
         if (login == null) { 
         }else{%>
         <br><br><br>
       <%}%>
         
       
  <div class="slider">
    <ul class="slides">
      <li>
        <img src="<%=request.getContextPath()%>/img/libro.jpg"> <!-- random image -->
       <!-- <div class="caption center-align">
          <h3>Crea tu propio libro</h3>
          <h5 class="light black-text text-lighten-3">Puedes hacer tu propio libro, <br> 
                    "mi primer libro"</h5>
        </div>-->
      </li>
      <li>
        <img src="<%=request.getContextPath()%>/img/libro1.jpg"> <!-- random image -->
       
       <!-- <div class="caption left-align">
          <h3>Calendarios Personalizados</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>-->
      </li>
      <li>
         <img src="<%=request.getContextPath()%>/img/libro2.jpg"> <!-- random image -->
        <!--<div class="caption right-align">
          <h3>Right Aligned Caption</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>-->
      </li>
      <li>
        <img src="<%=request.getContextPath()%>/img/libro3.jpg"> <!-- random image -->
        <!--<div class="caption center-align">
          <h3>This is our big Tagline!</h3>
          <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
        </div>-->
      </li>
    </ul>
  </div>
    
        <br>
<div class="row">
    <div class="col l10 offset-l1">
    
    <div class="col s12 l4">
      <div class="card">
        <div class="card-image">
          <img src="<%=request.getContextPath()%>/img/libro-impreso.jpg">
          <span class="titulocurso">Libro Impreso</span>
        </div>
        <div class="card-content">
          <p>Tapa blanda, tapa dura, en color, en blanco y negro y mucho más. 
              Elige entre la gama más amplia de formatos de libros impresos disponible 
              y crea exactamente el libro que desees.</p>
        </div>
        <div class="card-action">
          <a class="btn-small" href="ServletCompraCreaVende?nom=crearLibro">Crear libro impreso</a>
        </div>
      </div>
    </div>
        
    <div class="col s12 l4">
      <div class="card">
        <div class="card-image">
          <img src="<%=request.getContextPath()%>/img/calendario.jpg">
          <span class="titulocurso">Calendario Personalizado</span>
        </div>
        <div class="card-content">
          <p>A veces es difícil encontrar la inspiración para los regalos de navidad, 
              o para un cumpleaños. Muchas veces se nos acaban las ideas y no sabemos qué regalar. 
              ¡Con el calendario personalizado se acabaron los problemas! Es un regalo simple, 
              con un toque muy personal que complacerá a la persona que lo reciba. 
              Perfecto para cualquier ocasión.</p>
        </div>
        <div class="card-action">
          <a class="btn-small" href="#">Crear un calendario</a>
        </div>
      </div>
    </div>
                  
    <div class="col s12 l4">
      <div class="card">
        <div class="card-image">
          <img src="<%=request.getContextPath()%>/img/ebook.jpg">
          <span class="titulocurso">eBook</span>
        </div>
        <div class="card-content">
          <p>Independientemente de que los lectores utilicen Kindle, Nook, iPad, 
              Kobo o cualquier otro lector electrónico, 
              puedes crear un eBook apto para todos con rapidez y facilidad.</p>
        </div>
        <div class="card-action">
          <a class="btn-small" href="#">Crear un eBook</a>
        </div>
      </div>
    </div>
        
    </div>   
    
    
    
    
</div>   
        

         
        
      

        <script>
             document.addEventListener('DOMContentLoaded', function() {
             var elems = document.querySelectorAll('.slider');
             var instances = M.Slider.init(elems);
             });
        </script>