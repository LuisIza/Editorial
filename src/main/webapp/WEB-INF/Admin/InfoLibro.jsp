<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="com.mycompany.editorialaragon.controlador.CRUD.GenerosREAD"%>
<%@page import="java.util.Date"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.*"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<br><br>

<% LibroPublicadoEa libro = (LibroPublicadoEa) request.getAttribute("Mostrar");
    List<ArchivosLibroEa> archivos = (List<ArchivosLibroEa>) request.getAttribute("archivos");
    List<GenerosEa> generos = GenerosREAD.showGeneros();
    Thread.sleep(1500);
    if (libro != null) {
%>

<div class="row">
    <div class="col l12">


        <div class="col l10 offset-l1 s12 m10 offset-m1 blue-grey darken-3">
            <h2 class="tLibro "><%=libro.getNombreLibro()%></h2>
            <div class="card horizontal">
                <div class="card-image">
                    <a class="btn-floating halfway-fab modal-trigger blue-grey darken-1 hoverable camarita"  href="#foto-modal"><i class="material-icons" style="font-size:40px; padding-top: 15px">camera_alt</i></a>
                    <img src="<%=request.getContextPath()%>/upload/<%=libro.getUrlPortada()%>">
                </div>
                <div class="card-stacked">
                    <div class="card-content">
                        <a class="btn-floating modal-trigger blue-grey darken-1 hoverable right" href="#demo-modal"><i class="material-icons">edit</i></a>
                        <p><b>Autor: </b><%=libro.getAutor()%></p>
                        <p><b>Género: </b> <%=libro.getGenero()%></p>
                        <p><b>Categoria: </b><%=libro.getCategoria()%></p>
                        <p><b>Editorial: </b><%=libro.getEditorial()%></p>
                        <p><b>ISBN: </b><%=libro.getIsbn()%></p>
                        <p><b>Idioma: </b><%=libro.getIdioma()%></p>
                        <p><b>Páginas: </b><%=libro.getPaginas()%></p>
                        <% Double pd = libro.getDigital().doubleValue();
                            if (pd >= 0) {%>
                        <p><b> Precio libro Digital: </b><%=libro.getDigital()%> €</p>
                        <%}
                            Double pi = libro.getImpreso().doubleValue();
                            if (pi >= 0) {%>
                        <p><b>Precio libro Impreso: </b><%=libro.getImpreso()%> €</p>
                        <%}
                            if (libro.getEstado().equals("Solicitando")) {%>
                                <p><b>Visibilidad: </b>Solicitud pendiente autorización...</p>
                           <% } else{%>
                        <p><b>Visibilidad: </b><%=libro.getEstado()%></p>
                        <%}%>
                        <p><b>Ultima modificación: </b><%=(Date) libro.getFechaAlta()%></p>
                        <p ><b>Descripción:</b><br><%=libro.getDescripcion()%></p>


                    </div>
                    <div class="card-action">



                        <% if (archivos == null || archivos.isEmpty() || archivos.size() == 0) { %> 
                        <p>No hay ningun archivo...</p>
                        <h3>Archivos del Libro</h3>
                        <a href="#file-modal" class="btn-small modal-trigger blue-grey darken-1 hoverable right" ><i class="material-icons right">add</i>Añadir contenido</a>
                        <% } else { %>
                        <table class="striped">
                            <thead>
                                <tr>
                                    <th>Nombre del archivo</th>
                                    <th>Administrar   </th>
                                </tr>
                            </thead>

                            <tbody>
                                <%for (ArchivosLibroEa ar : archivos) {%>
                                <tr>
                                    <td><%=ar.getNombre()%></td>

                                    <td>
                                        &nbsp;&nbsp;
                                        <a onclick="borrarArchivo(<%=ar.getId()%>);" class="btn-floating red darken-1 right hoverable" ><i class="material-icons">delete</i>Eliminar</a>
                                    </td>
                                </tr>
                                <%}%>      

                            </tbody>
                        </table>



                        <%}%>

                        <br>
                        <br>

                        <a onclick="msg(<%=libro.getId()%>);" class="btn-floating red darken-1 hoverable hide-on-large-only" ><i class="material-icons right">delete</i>Borrar Libro</a>
                        <a onclick="msg(<%=libro.getId()%>);" class="btn red darken-1 hoverable hide-on-med-and-down" ><i class="material-icons right">delete</i>Borrar Libro</a>
                        <a href="IndexServlet" class="btn blue-grey darken-1 hoverable right" ><i class="material-icons right">close</i>Salir</a>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<br>       <br>

<div class="container">


    <!-- Modal Structure Informacion del libro -->
    <div id="demo-modal" class="modal">
        <div class="modal-content">
            <div class="row">
                <div class="col s12 m10 offset-m2 l10 offset-l1">
                    <form class="card" action="ActualizarDatosLibro" method="post" >
                        <div class="card-action blue-grey darken-1 	white-text">
                            <h4 class="center-align">Cambiar datos del libro</h4>
                        </div>
                        <div class="card-content ">
                            <div class='row black-text'>
                                <div class="input-field col s12 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text' type='text' value="<%=libro.getId()%>"  name='id' id='id' hidden/>
                                    <label for='id' hidden>ID:</label>
                                </div>
                            </div>

                            <div class='row black-text'>
                                <div class="input-field col s12 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='nombre' id='nombre' value="<%=libro.getNombreLibro()%>" required />
                                    <label for='nombre'>Nombre del Libro:</label>
                                </div>
                            </div>

                            <div class='row'>
                                <% if (generos != null) {%>      
                                <div class="col l6 m6 s6">
                                    <label>Genero:</label>
                                    <select class="browser-default" name="genero" id="genero" required>
                                        <option value="0" selected ><%=libro.getGenero()%></option>
                                        <% for (GenerosEa g : generos) {%>
                                        <option value="<%=g.getId()%>"><%=g.getGenero()%></option>

                                        <%}%>

                                    </select>
                                    <%}%>
                                </div>
                                <div class="col l6 m6 s6">
                                    <label>Categoria:</label>
                                    <select class="browser-default" name="categoria" id="categoria" required>
                                        <option value="0" selected ><%=libro.getCategoria()%></option>
                                        <option value="Otros">Otros</option>
                                    </select>
                                </div>

                            </div>



                            <div class='row black-text'>
                                <div class="input-field col l6 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='autor' id='autor' value="<%=libro.getAutor()%>" required />
                                    <label for='autor'>Autor:</label>
                                </div>
                                <div class="input-field col l6 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='editorial' id='editorial' value="<%=libro.getEditorial()%>" required />
                                    <label for='autor'>Editorial:</label>
                                </div>
                            </div>


                            <div class='row black-text'>
                                <div class="input-field col l4 m4 s4 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='isbn' id='isbn' value="<%=libro.getIsbn()%>" required />
                                    <label for='autor'>ISBN:</label>
                                </div>
                                <div class="input-field col l4 m4 s4">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='idioma' id='autor' value="<%=libro.getIdioma()%>" required />
                                    <label for='autor'>Idioma:</label>
                                </div>
                                <div class="input-field col l4 m4 s4 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='number' name='paginas' id='paginas' value="<%=libro.getPaginas()%>" required />
                                    <label for='autor'>Páginas:</label>
                                </div>
                            </div>


                            <div class='row black-text'>

                                <div class="input-field col s6 l6 m6 ">
                                    <% if (pi >= 0) {%>
                                    <label>
                                        <input type="checkbox" name="impreso" id="impreso" checked />
                                        <span>Libro Impreso</span>
                                    </label><br>
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='number' step='0.01' name='precioImpreso' id='precioImpreso' value="<%=libro.getImpreso()%>" />
                                    <%} else {%>
                                    <label>
                                        <input type="checkbox" name="impreso" id="impreso"/>
                                        <span>Libro Impreso</span>
                                    </label><br>
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='number' step='0.01' name='precioImpreso' id='precioImpreso'  disabled/>
                                    <%}%>
                                </div>

                                <div class="input-field col s6 l6 m6 ">
                                    <% if (pd >= 0) {%>
                                    <label>
                                        <input type="checkbox" name="digital" id="digital" checked />
                                        <span>Libro Digital</span>
                                    </label><br>
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='number' step='0.01' name='precioDigital' id='precioDigital' value="<%=libro.getDigital()%>" />
                                    <%} else {%>
                                    <label>
                                        <input type="checkbox" name="digital" id="digital" />
                                        <span>Libro Digital</span>
                                    </label><br>
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='number' step='0.01' name='precioDigital' id='precioDigital'  disabled/>
                                    <%}%>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12 ">
                                    <textarea name="descripcion" id="textarea1" class="materialize-textarea" ><%=libro.getDescripcion()%></textarea>
                                    <label for="textarea1">Descripción</label>
                                </div>
                            </div>
                            <div class='row'>
                                <label>Estado:</label>
                                <select class="browser-default" name="estado" id="estado" required>
                                    <option value="<%=libro.getEstado()%>" selected><%=libro.getEstado()%></option>
                                    <option value="Solicitando">Publicar</option>
                                    <option value="Oculto">Oculto al publico</option>
                                </select>
                            </div>
                            <br>

                            <div class="row">

                                <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action">Guardar cambios<i class="material-icons right">send</i> </button>

                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>

    </div>



    <!-- Modal Structure Foto del documento-->
    <div id="foto-modal" class="modal">
        <div class="modal-content">
            <div class="row">
                <div class="col s12 m8 offset-m2">
                    <form class="card" action="ActualizarPortadaLibro" method="post" enctype="multipart/form-data">
                        <div class="card-action blue-grey darken-1 	white-text">
                            <h4 class="center-align">Cambiar portada del libro</h4>
                            <h6 class="center-align" >Editorial Aragon</h6>
                        </div>
                        <div class="card-content ">
                            <div class='row black-text'>
                                <div class="input-field col s12 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text' type='text' value="<%=libro.getId()%>"  name='id' id='id' hidden/>
                                    <label for='id' hidden>ID:</label>
                                </div>
                            </div>

                            <div class="file-field input-field">
                                <div class="btn blue-grey darken-1">
                                    <span>Foto del libro:</span>
                                    <input type="file" name="foto" required accept="image/*" >
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text" placeholder="Seleccione archivo..." >
                                </div>
                            </div>


                            <br>
                            <div class="row">

                                <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action">Guardar Foto<i class="material-icons right">send</i> </button>

                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>

    </div>


    <!-- Modal Structure Archivos del documento-->
    <div id="file-modal" class="modal">
        <div class="modal-content">
            <div class="row">
                <div class="col s12 m8 offset-m2">
                    <form class="card" action="GuardarDocumentos" method="post" enctype="multipart/form-data">
                        <div class="card-action blue-grey darken-1 	white-text">
                            <h4 class="center-align">Añadir archivo</h4>
                            <h6 class="center-align" >Editorial Aragon</h6>
                        </div>
                        <div class="card-content ">

                            <div class='row black-text'>
                                <div class="input-field col s12 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text' type='text'  name='archivo' id='archivo'  required/>
                                    <label for='archivo' >Nombre:</label>
                                </div>
                            </div>

                            <div class="file-field input-field">
                                <div class="btn blue-grey darken-1">
                                    <span>Archivo del libro:</span>
                                    <input type="file" name="file" required accept=".pdf" >
                                </div>
                                <div class="file-path-wrapper">
                                    <input class="file-path validate" type="text" placeholder="Seleccione archivo..." >
                                </div>
                            </div>


                            <br>
                            <div class="row">

                                <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action">Guardar archivo<i class="material-icons right">send</i> </button>

                            </div>
                        </div>

                    </form>
                </div>

            </div>
        </div>

    </div>                                




</div>

<%}%>

<script type="text/javascript">
    $("#impreso").click(function () {
        if (!$("#impreso").is(":checked") && !$("#digital").is(":checked")) {
            $("#enviar").attr("disabled", "disabled");
        }
        if (this.checked) {
            $("#precioImpreso").removeAttr("disabled");
            $("#precioImpreso").attr("required", "required");
            $("#enviar").removeAttr("disabled");
        } else {
            $("#precioImpreso").val(null);
            $("#precioImpreso").attr("disabled", "disabled");
            $("#precioImpreso").removeAttr("required");


        }
    });
    $("#digital").click(function () {
        if (!$("#impreso").is(":checked") && !$("#digital").is(":checked")) {
            $("#enviar").attr("disabled", "disabled");
        }

        if (this.checked) {
            $("#precioDigital").removeAttr("disabled");
            $("#precioDigital").attr("required", "required");
            $("#enviar").removeAttr("disabled");
        } else {
            $("#precioDigital").val(null);
            $("#precioDigital").attr("disabled", "disabled");
            $("#precioDigital").removeAttr("required");

        }
    });
    $("#genero").bind("change", function () {

        $.ajax({
            //url: 'http://localhost:8080/EditorialAragon/rest/user/categorias', //Archivo local
            url: 'http://localhost:8070/ED/rest/user/categorias',  //Archivo Local
           // url: 'http://192.168.244.151:8070/ED/rest/user/categorias', // Archivo Servidor
            //url: 'http://2.136.31.72:8070/ED/rest/user/categorias', //Archivo Server
            data: JSON.stringify({id: $("#genero").val()}),
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            success: function (respuesta) {
                $('#categoria option').remove();
                if (respuesta.length === 0) {
                    $('#categoria').append(new Option("Otros", "Otros"));
                }
                $.each(respuesta, function (i, v) {
                    $('#categoria').append(new Option(v['categoria'], v['id']));
                });
            }
        });
    });

    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems);
    });

    function msg(id) {
        var opcion = confirm("Esta apunto de eliminar el libro \nDesea continuar?");
        if (opcion == true) {
            window.location.href = "BorrarLibroCompleto?id=" + id;
        }
    }

    function borrarArchivo(id) {
        var opcion = confirm("Esta apunto de eliminar el archivo \nDesea continuar?");
        if (opcion == true) {
            window.location.href = "BorrarArchivo?id=" + id;
        }
    }

</script>