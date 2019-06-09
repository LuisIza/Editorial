<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="com.mycompany.editorialaragon.controlador.CRUD.UserCRUD"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  
    UsuariosEa modUser = (UsuariosEa)request.getAttribute("modificar");
    if (modUser != null){
%>

    	<br>
	<div class="row">
		<div class="col s12 m6 offset-m3">
			<form class="card" action="GuardarUserModificado" method="post">
				<div class="card-action blue-grey darken-1 	white-text">
					<h4 class="center-align">Modificar Usuario</h4>
					<h6 class="center-align" >Editorial Aragon </h6>
				</div>
				<div class="card-content ">

                            <div class='row black-text'>
		              <div class="input-field col s12 ">
		              	<!--<i class="material-icons prefix">account_circle</i>-->
                                <input class='validate black-text' type='text' value="<%=modUser.getNombre()%>"  name='nombre' id='nombre' required />
		                <label for='nombre'>Nombre:</label>
		              </div>
		            </div>

		            <div class='row black-text'>
		              <div class="input-field col s12 ">
		              	<!--<i class="material-icons prefix">account_circle</i>-->
		                <input class='validate black-text ' type='text' name='email' value="<%=modUser.getEmail()%>" id='email' required />
		                <label for='email'>Email:</label>
		              </div>
		            </div>
					
                            <div class='row'>
		              <div class='input-field col s12'>
		              	<!--<i class="material-icons prefix">lock</i>-->
		                <input class='validate '  type='password' name='password' id='password'   />
		                <label for='password'>Contraseña nueva:</label>
		              </div>
		            </div>


		             <div class='row'>
					  <label>Permisos:</label>
					  <select class="browser-default" name="permisos" id="permisos" required>
					    <option value="<%=modUser.getPermisos()%>" selected><%=modUser.getPermisos()%></option>
					    <option value="Administrador">Administrador</option>
					    <option value="Profesor">Profesor</option>
					    <option value="Otro">Otro</option>
					  </select>
		            </div>

					<div class="row">

						 <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action">Guardar<i class="material-icons right">send</i> </button>

						  <button class="btn waves-effect waves-light blue-grey darken-1" type="button" id="salir"onclick="window.location.href='ControladorBotones?nom=iniciar';" >Cancelar<i class="material-icons right">close</i> </button>
					</div>
				</div>

			</form>
   
		</div>

	</div>
                              
    <%}%>
    
    
  