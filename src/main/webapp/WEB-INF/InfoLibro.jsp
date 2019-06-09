<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="java.util.Date"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br><br><br>
<% LibroPublicadoEa libro = (LibroPublicadoEa) request.getAttribute("Mostrar");
   //List<ArchivosLibroEa> archivos = (List<ArchivosLibroEa>) request.getAttribute("archivos");
    Thread.sleep(1000);
    String addItem =(String) request.getAttribute("ITEM");
    if (addItem != null){%>
    <input type="text" id='item' value="<%=addItem%>" hidden=""/>
    <%}
    if (libro != null) {
%>
<br><br>
<div class="row">
    <div class="col l10 offset-l1">

        <div class="col l10 offset-l1 s12 m8 offset-m2 blue-grey darken-3">
            <h2 class="tLibro" name="<%=libro.getId()%>"><%=libro.getNombreLibro()%></h2>
            <div class="card horizontal">
                <div class="card-image">
                    <img src="<%=request.getContextPath()%>/upload/<%=libro.getUrlPortada()%>">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <p><b>Autor: </b><%=libro.getAutor()%></p>
                        <p><b>Género: </b><%=libro.getGenero()%></p>
                        <p><b>Categoría: </b><%=libro.getCategoria()%></p>
                        <p><b>Editorial: </b><%=libro.getEditorial()%></p>
                        <p><b>ISBN: </b><%=libro.getIsbn()%></p>
                        <p><b>Idioma: </b><%=libro.getIdioma()%></p>
                        <p><b>Páginas: </b><%=libro.getPaginas()%></p>
                        <p><b>Ultima modificación: </b><%=(Date) libro.getFechaAlta()%></p><br>
                        <p ><b>Descripción:</b><br><%=libro.getDescripcion()%></p>


                    </div>
                    <div class="card-action">

                        <%if (libro.getDigital().doubleValue() == 0 && libro.getImpreso().doubleValue() < 0 ) {%>
                        <a class="btn-floating modal-trigger teal darken-1 hoverable left" href="#demo-modal"><i class="material-icons">file_download</i></a>
                        <p class="txtprecio">Solo digital</p>
                        <span class="lprecio">Gratis</span>
                        <%} else if (libro.getDigital().doubleValue() > 0 && libro.getImpreso().doubleValue() > 0 ) {%>

                        <a title="<%=libro.getNombreLibro()%>" id="<%=libro.getId()%> " name="<%=libro.getDigital()%>" class="btn-floating red hoverable left"><i class="material-icons">local_grocery_store</i></a>
                         <p class="txtprecio">Precio Tapa dura</p>
                        <span class="lprecio"><%=libro.getImpreso()%> €</span>
                         <p class="txtprecio">Precio digital</p>
                        <span class="lprecio"><%=libro.getDigital()%> €</span>
                        
                        <%} else if (libro.getDigital().doubleValue() > 0 && libro.getImpreso().doubleValue() < 0 ) {%>
                         <a title="<%=libro.getNombreLibro()%>" id="<%=libro.getId()%> " name="<%=libro.getDigital()%>" class="btn-floating red hoverable left" href="AddArticuloCesta?id=<%=libro.getId()%>&tipo=D" ><i class="material-icons">local_grocery_store</i></a>
                            <p class="txtprecio">Precio digital</p>
                            <span class="lprecio"><%=libro.getDigital()%> €</span>
                        <%}else{%>
                         <a title="<%=libro.getNombreLibro()%>" id="<%=libro.getId()%> " name="<%=libro.getDigital()%>" class="btn-floating red hoverable left" href="AddArticuloCesta?id=<%=libro.getId()%>&tipo=II"><i class="material-icons">local_grocery_store</i></a>
                         <p class="txtprecio">Precio Tapa dura</p>
                        <span class="lprecio"><%=libro.getImpreso()%> €</span>
                        <%}%>
                        <br><br>
                    </div>
                </div>
            </div>
        </div>



    </div>
</div>
<input type="text" id='librolibro' value="<%=libro.getId()%>" hidden=""/>

<%}%>
<br><br><br>




<!-- Modal Structure Informacion del libro -->
<div id="demo-modal" class="modal opacity">
    <div class="modal-content">
        <div class="row">
            <div class="col s12 m12 ">
                <form class="card" action="LibroGratis" method="post" >
                    <div class="card-action blue-grey darken-1 	white-text">
                        <h4 class="center-align DesTit"><%=libro.getNombreLibro()%></h4>
                    </div>
                    <div class="card-content ">

                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text' type='text' value="<%=libro.getId()%>"  name='id' id='id' hidden/>
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




<script type="text/javascript">
    /* $(document).ready(function () { 
       if($("#item").val().length > 2){
            var texto =$("#item").val();
             M.toast({html: texto});
        }   
        
     });*/

 
    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems);
    });


</script>