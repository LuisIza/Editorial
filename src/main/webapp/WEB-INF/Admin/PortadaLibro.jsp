<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.GenerosEa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.controlador.CRUD.GenerosREAD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<br><br>
<div class="row">
    <div class="col l8 offset-l2 s12 m10 offset-m1">
        <form class="card" action="GuardarLibro" method="post" enctype="multipart/form-data" >
            <div class="card-action blue-grey darken-1 	white-text">
                <h4 class="center-align">Añadir Portada</h4>
                <h6 class="center-align" >Editorial Aragon</h6>
            </div>
            <div class="card-content ">

                <div class="file-field input-field">
                    <div class="btn blue-grey darken-1">
                        <span>Foto del libro:</span>
                        <input type="file" name="foto" required accept="image/*" >
                    </div>
                    <div class="file-path-wrapper">
                        <input class="file-path validate" type="text" placeholder="Seleccione archivo..." >
                    </div>
                </div>

                <div class="row">

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action" >Guardar<i class="material-icons right">send</i> </button>

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="button" id="salir"onclick="window.location.href = 'index.jsp';"  >Cancelar<i class="material-icons right">close</i> </button>
                </div>
            </div>

        </form>
    </div>

</div>

