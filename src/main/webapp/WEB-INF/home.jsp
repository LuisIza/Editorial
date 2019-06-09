<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    
  <div class="slider fullscreen">
    <ul class="slides">
      <li>
        <img src="<%=request.getContextPath()%>/img/libro.jpg"> <!-- random image -->
        <!--<div class="caption right-align">
          <h3>Crea tu propio libro</h3>
          <h5 class="light black-text text-lighten-3">Puedes hacer tu propio libro, <br> 
              libro de fotos, álbum fotográfico, libro de bodas, <br> 
              libro de graduación (anuario), libro de bautizo, <br> 
              libro de recuerdos, libro del blog, libro de jubilación, "mi primer libro" <br> 
              ¡Nos enfocamos en la simplicidad y el fácil uso de nuestra página para desplegar toda tu creatividad!</h5>
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
         <img src="<%=request.getContextPath()%>/img/libro2.jpeg"> <!-- random image -->
       <!-- <div class="caption right-align">
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
    


        <script>
             document.addEventListener('DOMContentLoaded', function() {
             var elems = document.querySelectorAll('.slider');
             var instances = M.Slider.init(elems);
             });
        </script>