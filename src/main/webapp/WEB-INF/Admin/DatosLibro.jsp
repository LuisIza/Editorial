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
<% List<GenerosEa> generos = GenerosREAD.showGeneros();%>

<br><br><br>
<div class="row">
    <div class="col l8 offset-l2 s12 m10 offset-m1">
        <form class="card" action="GuardarDatosLibro" method="post">
            <div class="card-action blue-grey darken-1 	white-text">
                <h4 class="center-align">Alta Nuevo Libro</h4>
                <h6 class="center-align" >Editorial Aragon</h6>
            </div>
            <div class="card-content ">

                <div class='row black-text'>
                    <div class="input-field col s12 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='nombre' id='nombre' required />
                        <label for='nombre'>Nombre del Libro:</label>
                    </div>
                </div>


                <div class='row'>
                    <% if (generos != null) {%>      
                    <div class="col l6 m6 s6">
                        <label>Genero:</label>
                        <select class="browser-default" name="genero" id="genero" required>
                            <option value="género" selected disabled >Selecione un género</option>
                            <% for (GenerosEa g : generos) {%>

                            <option value="<%=g.getId()%>"><%=g.getGenero()%></option>

                            <%}%>

                        </select>
                        <%}%>
                    </div>
                    <div class="col l6 m6 s6">
                        <label>Categoria:</label>
                        <select class="browser-default" name="categoria" id="categoria" required>
                            <option value="Categoria" selected disabled >Selecione una categoria</option>
                            <option value="Otros">Otros</option>
                        </select>
                    </div>

                </div>


                <div class='row black-text'>
                    <div class="input-field col s6 l6 m6">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='autor' id='autor' required />
                        <label for='autor'>Autor:</label>
                    </div>
                    <div class="input-field col l6 m6 s6">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='editorial' id='editorial' value='Anonimo' />
                        <label for='autor'>Editorial:</label>
                    </div>
                </div>


                <div class='row black-text'>
                    <div class="input-field col s5 l4 m4 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='isbn' id='isbn' value="-------" />
                        <label for='autor'>ISBN:</label>
                    </div>
                    <div class="input-field col s5 m4 l4 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='text' name='idioma' id='autor' value="Castellano" required />
                        <label for='autor'>Idioma:</label>
                    </div>
                    <div class="input-field col s2 l4 m4 ">
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='number' name='paginas' id='paginas' />
                        <label for='autor'>Páginas:</label>
                    </div>
                </div>


                <div class='row black-text'>
                    <div class="input-field col s6 l6 m6 ">
                        <label>
                            <input type="checkbox" name="impreso" id="impreso" />
                            <span>Libro Impreso</span>
                        </label><br>
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='number' step='0.01' name='precioImpreso' id='precioImpreso' value="00,00"  disabled/>

                    </div>
                    <div class="input-field col s6 l6 m6 ">
                        <label>
                            <input type="checkbox" name="digital" id="digital" />
                            <span>Libro Digital</span>
                        </label><br>
                        <!--<i class="material-icons prefix">account_circle</i>-->
                        <input class='validate black-text ' type='number' step='0.01' name='precioDigital' id='precioDigital' value="00,00"  disabled/>

                    </div>
                </div>

                <div class="row">
                    <div class="input-field col s12 ">
                        <textarea name="descripcion" id="textarea1" class="materialize-textarea"></textarea>
                        <label for="textarea1">Descripción</label>
                    </div>
                </div>


                <br>


                <div class="row">

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="submit" id="enviar" name="action" disabled="">Continuar<i class="material-icons right">send</i> </button>

                    <button class="btn waves-effect waves-light blue-grey darken-1" type="button" id="salir"onclick="window.location.href = 'index.jsp';"  >Cancelar<i class="material-icons right">close</i> </button>
                </div>
            </div>

        </form>
    </div>

</div>


<script>


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
            //url: 'http://localhost:8080/EditorialAragon/rest/user/categorias',  //Archivo Local
            url: 'http://localhost:8070/ED/rest/user/categorias',  //Archivo Local
            //url: 'http://192.168.244.151:8070/ED/rest/user/categorias', //Archivo Server
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
</script>
