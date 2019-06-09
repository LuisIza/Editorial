<%-- 
    Document   : Layout
    Created on : 29-nov-2018, 20:33:10
    Author     : LUIS
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.*"%>
<%@page import="com.mycompany.editorialaragon.controlador.CRUD.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
       
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
        <title>EditotialAragon</title>
    </head>
    <body>

        <nav class="navbar-fixed blue-grey darken-1">
            <div class="nav-extended">
            <div class="nav-wrapper blue-grey darken-1">
                <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
                <a href="IndexServlet" class="brand-logo  "><i  class="material-icons left sidenav-trigger hide-on-small-only">book</i> Admin EA</a>
                <div class="nav-wrapper">

                    <ul class="right hide-on-med-and-down">
                        <% UsuariosEa login = (UsuariosEa) session.getAttribute("login");

                    if (login == null) { %>
                        <li><a href="ControladorBotones?nom=iniciar">Iniciar Sesion</a></li>
                            <% } else {

                     if (login.getPermisos().equals("Administrador")) {%>
                        <li><a href="ControladorBotones?nom=nuevoUser">Crear Usuario</a></li>
                        <li><a href="ControladorBotones?nom=nuevoLibro">Crear Libro</a></li>
                            <%} else if (login.getPermisos().equals("Profesor")) {%>
                        <li><a href="ControladorBotones?nom=nuevoLibro">Crear Libro</a></li>
                        <li><a href="IndexServlet">Gestion de Libros</a></li>
                            <% }%>
                        <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>

                        <% }%>

                    </ul>
                </div>

                        
            <%if (login != null) { %>

            <div class="nav-content">
                <div class="hola" style="background-color: black; width: 100%">

                    <a href="#" class="right mg white-text"><span class="hide-on-small-only">Bienvenido</span> <% out.print(login.getEmail()); %> &nbsp;</a>
                </div>  </div>    

        <% }%>
            
            </div>
            
            </div>
        </nav>
                        

                        

        <ul class="sidenav light-blue lighten-5" id="mobile-demo">

            <%if (login == null) { %>
            <li><a href="ServletBotonLogin">Iniciar Sesion</a></li>
                <% } else {

                     if (login.getPermisos().equals("Administrador")) {%>
            <li><a href="ServletBotonSignup">Crear Usuario</a></li>
            <li><a href="ServletBotonCrearLibro">Crear Libro</a></li>
                <%} else if (login.getPermisos().equals("Profesor")) {%>
            <li><a href="ServletBotonCrearLibro">Crear Libro</a></li>
            <li><a href="IndexServlet">Gestión de Libros</a></li>
                <% }%>
            <li><a href="ServletBotonCerrarSesion">Cerrar sesion</a></li>

            <% }%>

        </ul>             

            <br>
        <section>

            <jsp:include page="<%=((String) request.getAttribute("accion")) + ".jsp"%>"></jsp:include>


        </section>



        <footer class="page-footer blue-grey darken-1">
            <div class="container">
                <div class="row">
                    <div class="col l6 s12">
                        <h5 class="white-text">“No necesito un reloj despertador. Mis ideas me despiertan.”</h5>
                        <p class="grey-text text-lighten-4">“La creatividad es inventar, experimentar, crecer, tomar riesgos, romper reglas, cometer errores y divertirse.”</p>
                    </div>
                    <div class="col l4 offset-l2 s12">
                        <h5 class="white-text">Links</h5>
                        <ul>
                            <li><a class="grey-text text-lighten-3" href="https://materializecss.com/">Materealize</a></li>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2019 Copyright Disegned by LuisIza
                    <a class="grey-text text-lighten-4 right" href="#!">30-10-16</a>
                </div>
            </div>
        </footer>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.sidenav');
                var instances = M.Sidenav.init(elems);
            });
        </script>

    </body>
</html>
