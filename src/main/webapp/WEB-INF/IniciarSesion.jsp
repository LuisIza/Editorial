<%-- 
    Document   : iniciar
    Created on : 30-nov-2018, 16:40:40
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br><br><br><br>

<div class="row">
    <div class="col l10 offset-l1">
    
    <div class="col s12 l5 offset-l1">
      <div class="card">
        <div class="card-image">
          <img src="<%=request.getContextPath()%>/img/libro-impreso.jpg">
          <span class="titulocurso">Compra, Crea, imprime, etc...</span>
        </div>
        <div class="card-content">
          <p>Elige entre la gama más amplia de formatos de calendarios y libros impresos disponibles 
              y crea exactamente que desees.</p>
        </div>
        <div class="card-action">
          <a class="btn-large" href="ControladorBotones?nom=cliente"><i class="material-icons right">person</i>Cliente</a>
        </div>
      </div>
    </div>
        
    <div class="col s12 l5">
      <div class="card">
        <div class="card-image">
          <img src="<%=request.getContextPath()%>/img/calendario.jpg">
          <span class="titulocurso">Colabora con nosotros</span>
        </div>
        <div class="card-content">
          <p>Unete a nuestro equipo y colabora con nosotros, aqui puedes crear, publicar y vender libros.</p>
        </div>
        <div class="card-action">
          <a class="btn-large" href="ControladorBotones?nom=colaborador"><i class="material-icons right">group</i>Colaborador</a>
        </div>
      </div>
    </div>
                  
         
    </div>   
    
    
    
    
</div>   
        
<br><br><br><br>
           