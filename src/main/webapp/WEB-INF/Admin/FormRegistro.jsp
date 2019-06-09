<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br><br>
<br>
<div class="row">
    <div class="col s12 m6 offset-m3">
        <form class="card" action="ServletGuardarUser" method="post">
            <div class="card-action blue-grey darken-1 	white-text">
                <h4 class="center-align">ALTA USUARIO NUEVO</h4>
                <h6 class="center-align" >Editorial Aragon</h6>
            </div>
            <div class="card-content ">

                <div class='row black-text'>
                    <div class="input-field col s12 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='nombre' id='nombre' required />
                        <label for='nombre'>Nombre:</label>
                    </div>
                </div>

                <div class='row black-text'>
                    <div class="input-field col s12 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='email' id='email' required />
                        <label for='email'>Email:</label>
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
                        <input class='validate black-text ' type='text' name='permisos' id='permisos' value="Publicador" hidden />

                    </div>
                </div>

                <div class="row">

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action">Guardar<i class="material-icons right">send</i> </button>

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="button" id="salir" onclick="window.location.href = 'ControladorBotones?nom=colaborador';"  >Cancelar<i class="material-icons right">close</i> </button>
                </div>
            </div>
        
            <% if (request.getAttribute("error") != null) {%>
            <div><h4 class="center-align"><%= (String) request.getAttribute("error")%></h4></div>

            <%}%>
            <br
        </form>
    </div>

</div>



