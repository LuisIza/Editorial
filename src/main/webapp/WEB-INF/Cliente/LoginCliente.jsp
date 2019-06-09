<%-- 
    Document   : iniciar
    Created on : 30-nov-2018, 16:40:40
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br><br><br><br>
<div class="row">
    <div class="col l6 offset-l3 s12 m10 offset-m1">
        <form class="card" action="ServletLogin" method="post">
            <div class="card-action blue-grey darken-1 	white-text">
                <h4 class="center-align">Iniciar sesión</h4>
                <h6 class="center-align" >Editorial Aragon</h6>
            </div>
            <div class="card-content ">

                <div class='row black-text'>
                    <div class="input-field col s12 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='nombre' id='username' required />
                        <label for='username'>Email:</label>
                    </div>
                </div>

                <div class='row'>
                    <div class='input-field col s12'>
                        <!--<i class="material-icons prefix">lock</i>-->
                        <input class='validate ' type='password' name='password' id='password'  required />
                        <label for='password'>Contraseña:</label>
                    </div>
                </div>
                <div class='row black-text'>
                    <div class="input-field col s12 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='tipo' id='tipo' value="cli" hidden />

                    </div>
                </div>

                <div class="row">

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" name="action">Entrar<i class="material-icons right">send</i> </button>
                    <button class="btn waves-effect waves-light blue-grey darken-1 right" type="button" id="salir"onclick="window.location.href='ControladorBotones?nom=iniciar';">Cancelar<i class="material-icons right">close</i> </button>
                </div>
            </div>
            
                    <div class="row">
                        <div class="col l10 offset-l1">
                          <p class="margin center-align">Si aun no estas registrado crea tu cuenta ahora... <a href="ControladorBotones?nom=cuentacliente">aqui</a></p>
                        </div>

                    </div>
            
            <% if (request.getAttribute("error") != null) {%>
            <div><h4 class="center-align"><%= (String) request.getAttribute("error")%></h4></div>

        <%}%>
        <br>
        </form>
  <br>
  
    </div>

</div>

  <br>  <br>

           