<%-- 
    Document   : DetallesCompra
    Created on : 07-may-2019, 16:11:37
    Author     : Luis
--%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.ArchivosCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  PedidosImpresos libro = (PedidosImpresos) session.getAttribute("Carrito");
    if (libro != null) {
%>
<br>
<br><br><br><br><br><br><br><br>

<div class="row">

    <div class="col l10 offset-l1 m12">

        <div class="card">


            <div class="card-image">
                <span class="titulocurso">Detalles de la Compra: REF-<%=libro.getReferencia()%></span>
            </div>
            <div class="card-content">

                <table class="striped responsive-table " style="font-size:18px;">
                    <thead class="">
                        <tr>
                            <th>Tipo</th>
                            <th>Codigo</th>
                            <th>Cantidad</th>
                            <th>Nº Paginas</th>
                            <th>P. Unidad</th>
                            <th class="right">Total a pagar</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td><img src="<%=request.getContextPath()%>/img/lb.jpg" alt="" class="circle responsive-img"></td>
                            <td><span><%= libro.getProducto()%></span></td>
                            <td><span><%= libro.getCantidad()%></span></td>
                            <td><span><%= libro.getPaginas()%></span></td>
                            <td style="text-align: right"><span class="" id="precio"><%= libro.getPrecio().setScale(2, RoundingMode.DOWN)%> €</span></td>
                            <% BigDecimal total = new BigDecimal(libro.getCantidad() * (libro.getPrecio().doubleValue()));%>
                            <td style="text-align: right"><span class="" id="precio"><%= total.setScale(2, RoundingMode.DOWN)%> €</span></td>
                        </tr>

                    </tbody>
                </table>
                <br>
                <div class="content">

                    <div class="card-content ">

                        <form class="card ref" action="GuardarCompraLI" method="post" enctype="multipart/form-data">


                            <fieldset>
                                <legend>Archivo pdf del libro</legend>
                                <div class="file-field input-field">
                                    <div class="btn blue-grey darken-1">
                                        <span>Archivo del libro:</span>
                                        <input type="file" name="file" required  >
                                    </div>
                                    <div class="file-path-wrapper">
                                        <input class="file-path validate" type="text" placeholder="Seleccione archivo..." accept=".pdf">
                                    </div>
                                </div>
                            </fieldset>
                            <br><br>
                            <fieldset>
                                <legend>Datos de envio</legend>

                                <div class='row black-text'>
                                    <div class="input-field col m6 s12 ">
                                        <i class="material-icons prefix">account_circle</i>
                                        <input class='validateblack-text ' type='text' name='nombre' id='nombre' required />
                                        <label for='nombre'>Nombre:</label>
                                    </div>
                                    <div class="input-field col m6 s12 ">
                                        <i class="material-icons prefix">create</i>
                                        <input class='validate black-text ' type='text' name='apellidos' id='apellidos' required />
                                        <label for='apellidos'>Apellidos:</label>
                                    </div>

                                </div>

                                <div class='row black-text'>
                                    <div class="input-field col m6 s12">
                                        <i class="material-icons prefix">contact_mail</i>
                                        <input class='validate black-text ' type='text' name='email' id='email' required />
                                        <label for='email'>Email de contacto:</label>
                                    </div>
                                    <div class="input-field col m6 s12 ">
                                        <i class="material-icons prefix">phone</i>
                                        <input class='validate black-text ' type='text' name='telefono' id='telefono' required />
                                        <label for='telefono'>Teléfono de contacto:</label>
                                    </div>
                                </div>

                                <fieldset>
                                    <legend>Dirección de envio</legend>
                                    <div class='row black-text'>
                                        <div class="input-field col m4 s12 ">
                                            <i class="material-icons prefix">public</i>
                                            <input class='validate black-text ' type='text' name='direccion' id='direccion' required />
                                            <label for='direccion'>Pais</label>
                                        </div>
                                        <div class="input-field col m4 s12 ">
                                            <i class="material-icons prefix">map</i>
                                            <input class='validate black-text ' type='text' name='telefono' id='telefono' required />
                                            <label for='telefono'>Ciudad</label>
                                        </div>
                                        <div class="input-field col m4 s12 ">
                                            <i class="material-icons prefix">location_city</i>
                                            <input class='validate black-text ' type='text' name='telefono' id='telefono' required />
                                            <label for='telefono'>Código postal</label>
                                        </div>
                                    </div>
                                    <div class='row black-text'>
                                        <div class="input-field col m6 s12 ">
                                            <i class="material-icons prefix">location_on</i>
                                            <input class='validate black-text ' type='text' name='direccion' id='direccion' required />
                                            <label for='direccion'>Calle, via, plaza, etc...</label>
                                        </div>
                                        <div class="input-field col m3 s6 ">

                                            <input class='validate black-text ' type='text' name='num' id='num' required />
                                            <label for='num'>Número:</label>
                                        </div>
                                        <div class="input-field col m3 s6 ">

                                            <input class='validate black-text ' type='text' name='portal' id='portal' required />
                                            <label for='portal'>Portal:</label>
                                        </div>
                                    </div>
                                </fieldset>


                            </fieldset>
                            <br>   <br>   

                            <fieldset>
                                <legend>Selecione el método de pago</legend>
                                
                   <div class='row black-text'>
                    <div class="input-field col s6 l6 m6 ">
                      
                        <label>
                            <input type="checkbox" name="transf" id="trnasf" checked='on' required/>
                            <span>Pago por transferencia</span>
                        </label>  <br>
                        <!--<i class="material-icons prefix">account_circle</i>
                        <i class="material-icons">local_atm</i>-->
                       

                    </div>
                    <div class="input-field col s6 l6 m6 ">
                        <label>
                            <input type="checkbox" name="reem" id="reem" disabled="" />
                            <span>Pago contra reembolso</span>
                        </label><br>
                        <!--<i class="material-icons prefix">account_circle</i>-->
                       

                    </div>
                </div>
                            </fieldset>
                            <br>   

                            <div class='row black-text' >
                                <button class=" col m6 s12 btn-large blue-grey darken-1 hoverable" type="button" onclick="window.location.href = 'ServletCompraCreaVende?nom=crear';" style="font-weight: bold">Cancelar compra</button>
                                <button class="col m6 s12 btn-large red hoverable" type="submit" style="font-weight: bold">Finalizar compra</button>
                            </div>

                        </form>
                    </div>


                </div> 

                <br>

            </div>

        </div>

    </div>


</div>
<%}%>

<br><br>



<script>

    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.modal');
        var instances = M.Modal.init(elems);
    });
</script>