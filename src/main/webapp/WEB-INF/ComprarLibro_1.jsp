<%-- 
    Document   : Comprar
    Created on : 20-may-2019, 17:32:52
    Author     : LUIS
--%>

<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.controlador.CRUD.LibroCRUD"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% UsuariosEa login = (UsuariosEa) session.getAttribute("login");
    List<LibroPublicadoEa> lista = LibroCRUD.showAllLibrosVenta();
    if (login == null) {
      } else {%>
  <br><br><br>
<%}%>


<div class="slider">
    <ul class="slides">
        <li>
            <img src="<%=request.getContextPath()%>/img/slider-libro1.jpg"> <!-- random image -->
            <!-- <div class="caption center-align">
               <h3>Crea tu propio libro</h3>
               <h5 class="light black-text text-lighten-3">Puedes hacer tu propio libro, <br> 
                         "mi primer libro"</h5>
             </div>-->
        </li>
        <li>
            <img src="<%=request.getContextPath()%>/img/slider-libro2.jpg"> <!-- random image -->

            <!-- <div class="caption left-align">
               <h3>Calendarios Personalizados</h3>
               <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
             </div>-->
        </li>
        <li>
            <img src="<%=request.getContextPath()%>/img/slider-libro1.jpg"> <!-- random image -->
            <!--<div class="caption right-align">
              <h3>Right Aligned Caption</h3>
              <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
            </div>-->
        </li>
        <li>
            <img src="<%=request.getContextPath()%>/img/slider-libro2.jpg"> <!-- random image -->
            <!--<div class="caption center-align">slider-libro1.jpg
              <h3>This is our big Tagline!</h3>
              <h5 class="light grey-text text-lighten-3">Here's our small slogan.</h5>
            </div>-->
        </li>
    </ul>
</div>

<br>
<%   if (lista != null) {%>
<div class="row">
    <div class="col l10 offset-l1" id="libros">
        <% 
        for (LibroPublicadoEa lp : lista) {%>
        <div class="col s6 l2 m4">
            <div class="card hoverable">
                <div class="card-image">
                    <a  href="BotonInfoLibroComprar?id=<%=lp.getId()%>"><img src="<%=request.getContextPath()%>/upload/<%=lp.getUrlPortada()%>"></a>
                    <span class="titlibro"><%=lp.getNombreLibro()%></span>
                </div>

                <div id ="codigos" class="card-action">
                   
                    <% if (lp.getDigital().doubleValue() == 0 && lp.getImpreso().doubleValue()< 0) {%>
                    <a title="<%=lp.getNombreLibro()%>" id="<%=lp.getId()%>" name="gratis" class="btn-floating modal-trigger teal darken-1 hoverable left" href="#demo-modal"><i class="material-icons">file_download</i></a>
                        <span class="lprecio">Gratis</span>
                    <%}else{%>
                    <a title="<%=lp.getNombreLibro()%>" id="<%=lp.getId()%> " name="<%=lp.getDigital()%>" class="btn-floating red hoverable left" ><i class="material-icons">local_grocery_store</i></a>
                    <span class="lprecio"><%=lp.getDigital()%> €</span>
                    <%}%>
                    <br><br>
                </div>
            </div>
        </div>
        <%  }  %>

    </div>
</div>


<%}%>        


<!-- Modal Structure Informacion del libro -->
<div id="demo-modal" class="modal opacity">
    <div class="modal-content">
        <div class="row">
            <div class="col s12 m10 offset-m1">
                <form class="card" action="LibroGratis" method="post" >
                    <div class="card-action blue-grey darken-1 	white-text">
                        <h4 class="center-align DesTit" id="nombreL"></h4>
                    </div>
                    <div class="card-content ">

                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text' type='text' value=""  name='id' id='id' hidden/>
                        <label for='id' hidden>ID:</label>
                      
                        <div class='row black-text'>
                            <div class="input-field col s12 ">
                                <span>
                                    Enviaremos el link de descarga del libro al emial que nos faciliten.<br>
                                    Algunos servidores de correo pueden bloquear el email y ponerlo en la carpeta de correo no deseado.
                                </span>
                            </div>
                        </div>
                        <div class='row black-text'>
                            <div class="input-field col s6 ">
                                <!--<i class="material-icons prefix">account_circle</i>-->
                                <input class='validate black-text ' type='text' name='nombre' id='nombre' required />
                                <label for='nombre'>Nombre:</label>
                            </div>
                              <div class="input-field col s6 ">
                                <!--<i class="material-icons prefix">account_circle</i>-->
                                <input class='validate black-text ' type='email' name='email' id='email' required />
                                <label for='email'>Email:</label>
                            </div>
                        </div>

                        <div class='row black-text'>
                            <div class="input-field col s12 ">
                                <label>
                                    <input type="checkbox" name="terminos" required="" />
                                    <span>Acepto las Condiciones de servicio y la Política de privacidad de Editorial Aragon.</span>
                                </label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s12 ">

                            </div>
                        </div>

                        <br>

                        <div class="row">

                            <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action">Enviar información<i class="material-icons right">send</i> </button>

                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>

</div>









<script>
    
$("#codigos a").click(function(){
        var cod=($(this).attr('id'));
        var nom =($(this).attr('title'));
        var precio = ($(this).attr('name'));
        if (precio === "gratis"){
            $("#id").val(cod);
            $("#nombreL").html(nom);
        }else{
            con = con +1;
            carrito.push(cod,nom,precio);
            $("#numCarrito").html(con);
        }
    });
   
      document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems);
    });
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.slider');
        var instances = M.Slider.init(elems);
    });
</script>