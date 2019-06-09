<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="java.util.Date"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.ArchivosPublicidad"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.PublicidadEa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<br>
<br><br><br><br>

<% PublicidadEa libro = (PublicidadEa) request.getAttribute("Mostrar");
    List<ArchivosPublicidad> archivos =(List<ArchivosPublicidad>) request.getAttribute("archivos");
    Thread.sleep(1500);
    if (libro != null) {
%>

<div class="row">
    <div class="col l10 offset-l1">
        <div class="row">
            <div class="col l8 offset-l2 s12 m10 offset-m1">
                <div class="card">
                    <div class="card-image">
                        <a class="btn-floating halfway-fab modal-trigger blue-grey darken-1 hoverable right" href="#foto-modal"><i class="material-icons">camera_alt</i></a>
                        <img src="<%=request.getContextPath()%>/upload/<%=libro.getUrlPortada()%>">

                        <span class="titulocurso"><%=libro.getNombreLibro()%></span>

                    </div>
                    <div class="card-content">
                        <!-- Modal Trigger -->
                        <a class="btn-floating modal-trigger blue-grey darken-1 hoverable right" href="#demo-modal"><i class="material-icons">edit</i></a>
                        <p><b>Autor: </b><%=libro.getAutor()%></p>
                        <p><b>Categoria: </b><%=libro.getCategoria()%></p>
                        <p><b>Visibilidad: </b><%=libro.getEstado()%></p>
                        <p><b>Ultima modificación: </b><%=(Date)libro.getFechaAlta()%></p>
                        <p><b>Descripción:</b><br><%=libro.getDescripcion()%></p>
                    </div>
                    <div class="card-action">
                        
                         <h3>Archivos del Libro</h3>
                         <a href="#file-modal" class="btn-small modal-trigger blue-grey darken-1 hoverable right" ><i class="material-icons right">add</i>Añadir contenido</a>
                         
                         <% if (archivos == null || archivos.isEmpty() || archivos.size()==0){ %> 
                          <p>No hay ningun archivo...</p>
                          
                         <% }else{ %>
                         <table class="striped">
                             <thead>
                                 <tr>
                                     <th>Nombre del archivo</th>
                                     <th>Administrar   </th>
                                 </tr>
                             </thead>
                            
                             <tbody>
                                 <%for (ArchivosPublicidad ar : archivos) {%>
                                 <tr>
                                     <td><%=ar.getNombre()%></td>

                                     <td>
                                        &nbsp;&nbsp;
                                         <a onclick="borrarArchivo(<%=ar.getId()%>);" class="btn-floating red darken-1 right" ><i class="material-icons">delete</i>Eliminar</a>
                                     </td>
                                 </tr>
                                 <%}%>      

                             </tbody>
                         </table>
                       
                       
                        
                        <%}%>
                        
                                 <br>
                                 <br>

                        <a onclick="msg(<%=libro.getId()%>);" class="btn red darken-1 hoverable" ><i class="material-icons right">delete</i>Borrar Libro</a>
                        <a href="IndexServlet" class="btn blue-grey darken-1 hoverable right" ><i class="material-icons right">close</i>Salir</a>
                        <br>
                        <br>
                    </div>
                </div> 

            </div>
        </div>
    </div>
</div>

<div class="container">


    <!-- Modal Structure Informacion del libro -->
    <div id="demo-modal" class="modal">
        <div class="modal-content">
            <div class="row">
                <div class="col s12 m8 offset-m2">
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
                            <div class='row black-text'>
                                <div class="input-field col s12 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='categoria' id='categoria' value="<%=libro.getCategoria()%>" required />
                                    <label for='categoria'>Categoria:</label>
                                </div>
                            </div>
                            <div class='row black-text'>
                                <div class="input-field col s12 ">
                                    <!--<i class="material-icons prefix">account_circle</i>-->
                                    <input class='validate black-text ' type='text' name='autor' id='autor' value="<%=libro.getAutor()%>" required />
                                    <label for='autor'>Autor:</label>
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
					    <option value="Publicado">Publicar</option>
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
                                    <input class='validate black-text' type='text'  name='archivo' id='archivo' required/>
                                    <label for='archivo' >Nombre:</label>
                                </div>
                            </div>

                            <div class="file-field input-field">
                                <div class="btn blue-grey darken-1">
                                    <span>Archivo del libro:</span>
                                    <input type="file" name="file" required  >
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