<%-- 
    Document   : Layout
    Created on : 29-nov-2018, 20:33:10
    Author     : LUIS
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="com.mycompany.editorialaragon.controlador.ObjetoCarrito"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.*"%>
<%@page import="com.mycompany.editorialaragon.controlador.CRUD.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Compiled and minified CSS -->
        <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">-->
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/script.js">
        </script>
        <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.js"></script>
        <script src="<%=request.getContextPath()%>/js/materialize.js"></script>
        <script src="<%=request.getContextPath()%>/js/materialize.min.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css">
        <title>EditotialAragon</title>
    </head>
    <body>
        <input type="text" id='menumenu' value="menu" hidden=""/>
         <% String addItem =(String) request.getAttribute("ITEM");
    if (addItem != null){%>
    <input type="text" id='item' value="<%=addItem%>" hidden=""/>
    <%}%>


        <nav class="navbar-fixed blue-grey darken-1">
            <div class="nav-extended">

                <div class="nav-wrapper">
                    <a href="#" data-target="mobile-demo" class="sidenav-trigger"><i class="Large material-icons">menu</i></a>
                    <a href="IndexServlet" class="brand-logo"><img class="logoED" src="<%=request.getContextPath()%>/img/logoED.png" alt=""/></a>
                </div>

                <div class="nav-wrapper">

                    <ul class="right hide-on-med-and-down">
                        <% UsuariosEa login = (UsuariosEa) session.getAttribute("login");
                                       List<LibroPublicadoEa> noti = (List<LibroPublicadoEa>) request.getAttribute("notificacion");
                        int numNot= 0;
                        if (noti != null){
                           numNot = noti.size();
                        }
                          if (login == null) { %>
                        <li><a href="ControladorBotones?nom=iniciar">Iniciar Sesion</a></li>
                            <% } else if (login.getPermisos().equals("Cliente")) {%>
                        <li><a href="ControladorBotones?nom=creaciones">Mis Creaciones</a></li>
                        <li><a href="ControladorBotones?nom=historial">Historial de compras</a></li>
                        <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>
                            <% } else if (login.getPermisos().equals("Administrador")) {%>
                         <li><a href="ControladorBotones?nom=gestion">Gestion de usuarios</a></li>
                        <li><a href="ControladorBotones?nom=nuevoUser">Crear Usuario</a></li>
                        <%if(numNot == 0){%>
                        <li><a href="ControladorBotones?nom=administrar">Administracion Libros</a></li>
                        <%}else{%>
                        <li><a href="ControladorBotones?nom=administrar">Administracion Libros<span class="new badge red"><%=numNot%></span></a></li>
                        <%}%>
                        <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>
                            <%} else if (login.getPermisos().equals("Publicador")) {%>
                        <li><a href="ControladorBotones?nom=nuevoLibro">Crear Libro</a></li>
                        <li><a href="IndexServlet">Gestion de libros</a></li>
                        <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>
                            <%}%>
                    </ul>
                </div>


            </div>
        </nav>
        <%  List<ObjetoCarrito> carritoC = (List<ObjetoCarrito>) session.getAttribute("CarritoCompra");
        if (login == null || login.getPermisos().equals("Cliente")) { %>
        <div class="navbar-fixed blue-grey darken-1 ccv">
            <ul class="tabs tabs-transparent">
                <li class="tab hoverable"><a href="ServletCompraCreaVende?nom=compra">Comprar</a></li>
                <li class="tab hoverable"><a href="ServletCompraCreaVende?nom=crear">Crear</a></li>
                <!--<li class="tab hoverable"><a href="ServletCompraCreaVende?nom=vende">Vender</a></li>-->
                <li class="tab "><a href="#"></a></li>

            </ul>
            
            <a href="#" data-target="mobile-demoC" class="sidenav-trigger">
                <div class="carCar">

                    <span class="hide-on-med-and-down">Mi Carrito</span>

                    <i class="carrito material-icons right">shopping_cart</i>
                </div>
                <div class="expcar">
                    <% if (carritoC == null) {%>
                    <span id="numCarrito" class="num">0</span>
                    <%} else {%>
                    <span id="numCarrito" class="num"><%=carritoC.size()%></span>
                    <%}%>
                </div>

            </a>
        </div>
        <% }
            if (login != null) { %>
        <div class="navbar-fixed hola ">

            <a href="#" class="right mg white-text"><span class="hide-on-small-only">Bienvenido</span> <% out.print(login.getEmail()); %> &nbsp;</a>
        </div>  <br><br>  
        <% }%>



        <%--------------------------CARRITO DE LA COMPRA ---------------------%>
        <div class="sidenav blue-grey lighten-3" id="mobile-demoC" >
            <p class="titcar">Artículos en tu cesta</p>
             <% if(carritoC != null){%>
                <table class="striped">
                    <thead>
                        <tr><th colspan="3">Detalles del articulo</th></tr>
                    </thead>
                    <tbody>
                        <% int num=0;
                           double total=0;
                            for (ObjetoCarrito oc : carritoC){
                                num++;  %>
                        <tr><td colspan="3">
                                 <a onclick="msgs('<%=oc.getCodigoLibro()%>');" class="btn-floating red darken-1 right hoverable" ><i class="material-icons">delete</i>Eliminar</a>
                                <div class="carLibro"><%=oc.getNombre()%></div>
                                <span class="txtpre">Tipo</span>
                                <span class="txtpre">Cant.</span>
                                <span class="txtpre">Precio</span>
                                <div class="row">
                                    
                                     <input type="text" name="art" value="<%=oc.getCodigoLibro()%>"  hidden=""/>
                                     
                                    <div class="col l5 s5">
                                        <span class="dtpre"><%=oc.getTipo()%></span>
                                    </div>
                                    <div class="col l3 s3">
                                     
                                       <span class="dtpre"><%=oc.getCatidad()%></span>
                                    </div>
                                    <div class="col l4 s4">
                                        <span class="dtprec"><%=oc.getPrecio()%> €</span>
                                    </div>
                                </div>

                            </td></tr>
                      <% int cantidad = oc.getCatidad();
                        BigDecimal precio = oc.getPrecio();
                          total = total + (cantidad * precio.doubleValue());
                              }%>
                    </tbody>
                </table>
                   
                    <div class="row">
                        <br>
                        <span class="totalcar">TOTAL A PAGAR: <%=total%> €</span><br>
                      
                        <button type="submit" class="btn col m12 hoverable" onclick="window.location.href = 'VaciarCarrito';">Vaciar carrito</button>
                        <button type="submit" class="btn-large col m12  deep-orange darken-4 hoverable" style="font-weight: bold" onclick="window.location.href = 'FinalCompraLibros';">Finalizar compra</button>
                    </div>
             
                    
                <%}else{%>
                <p style="text-align: center"> No hay articulos selecionados...</p>
                <%}%>
                
 

          
        </div>  



        <ul class="sidenav blue-grey lighten-3" id="mobile-demo">
            <%if (login == null) { %>
            <li><a href="ControladorBotones?nom=iniciar">Iniciar Sesion</a></li>
                <% } else if (login.getPermisos().equals("Cliente")) {%>
            <li><a href="ControladorBotones?nom=creaciones">Mis Creaciones</a></li>
            <li><a href="ControladorBotones?nom=historial">Historial de compras</a></li>
            <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>
                <% } else if (login.getPermisos().equals("Administrador")) {%>
            <li><a href="ControladorBotones?nom=gestion">Gestion de usuarios</a></li>
            <li><a href="ControladorBotones?nom=nuevoUser">Crear Usuario</a></li>
                        <%if(numNot == 0){%>
                        <li><a href="ControladorBotones?nom=administrar">Administracion Libros</a></li>
                        <%}else{%>
                        <li><a href="ControladorBotones?nom=administrar">Administracion Libros<span class="new badge red"><%=numNot%></span></a></li>
                        <%}%>
            <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>
                <%} else if (login.getPermisos().equals("Publicador")) {%>
            <li><a href="ControladorBotones?nom=nuevoLibro">Crear Libro</a></li>
            <li><a href="IndexServlet">Gestion de libros</a></li>
            <li><a href="ControladorBotones?nom=salir">Cerrar sesion</a></li>
                <%}%>

        </ul>     



  
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
                            <li><a class="grey-text text-lighten-3"  href="http://cenv.es/">CEWORKING VALENCIA</a></li>
                            <li><a class="grey-text text-lighten-3" href="http://cencoworking.com/">CEWORKING - PALMA DE MALLORCA</a></li>
                            <li><a class="grey-text text-lighten-3" href="http://institutovictoria.com">Instituto Victoria</a></li>
                            <li><a class="grey-text text-lighten-3" href="https://druusproject.com/">Druus Project</a></li>
                            <li><a class="grey-text text-lighten-3" href="https://materializecss.com/">Materealize</a></li>

                        </ul>
                    </div>
                </div>
            </div>
            <div class="footer-copyright">
                <div class="container">
                    © 2019 Copyright Disegned by DruusProject - 
                    <a class="grey-text text-lighten-4" href="#!">Todos los derechos reservados </a>
                </div>
                 <!--<div class="container">
                    © 2019 Copyright Disegned by LuisIza
                    <a class="grey-text text-lighten-4 right" href="#!">30-10-16</a>
                </div>-->
            </div>
        </footer>

        <script>
            function msgs(id){
            var opcion = confirm("Eliminar Articulo de la cesta \nDesea continuar");
            var menu = $("#menumenu").val();
            var libro = $("#librolibro").val();
            if (opcion == true) {
                //$('#cesta').remove();
                window.location.href ="BorrarElementoCesta?id="+id+"&cc="+menu+"&lib="+libro;
                }
           }
            

         $(document).ready(function () {
        if($("#item").val().length > 2){
            var texto =$("#item").val();
             M.toast({html: texto});
             //M.toast({html: 'Libro añadido correctamente'});
        }   
        
     });
            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.sidenav');
                var instances = M.Sidenav.init(elems);
            });
        </script>

    </body>
</html>
