<%-- 
    Document   : DetallesCompra
    Created on : 07-may-2019, 16:11:37
    Author     : Luis
--%>

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.CodigosLibros"%>
<%@page import="com.mycompany.editorialaragon.controlador.ObjetoCarrito"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<ObjetoCarrito> carrito = (List<ObjetoCarrito>) session.getAttribute("CarritoCompra");
    CodigosLibros ref = (CodigosLibros) session.getAttribute("REF");
   
    if (carrito != null) {
        
%>
<br>
<br><br><br><br><br><br><br><br>

<div class="row">
   
    <div class="col l10 offset-l1 m12">
 
        <div class="card">
                

                <div class="card-image">
                    <span class="titulocurso"><b>Detalles de la Compra Libros:</b> REF-<%=ref.getReferencia()%></span>
                </div>
                <div class="card-content">

                    <table class="striped" id="cesta">
                        <thead class="">
                            <tr>
                                <th>Codigo libro</th>
                                <th>Nombre del libro</th>
                                <th>Tipo</th>
                                <th class="right-align">Cantidad</th>
                                <th class="right-align">Precio Unitario</th>
                                <th class="right-align">Acciones</th>
                            </tr>
                        </thead>

                        <tbody>
                            <% int con = 0;
                            double total=0;
                                for( ObjetoCarrito c : carrito ){ 
                            con++;%>
                            <tr>
                                <td><input type="text" name="codigo"  value="<%= c.getCodigoLibro()%>" hidden="">LD-<%= c.getCodigoLibro()%></td>
                                <td><%=c.getNombre()%></td>
                                <td><%=c.getTipo()%></td>
                                <% total = total + c.getPrecio().doubleValue();
                                    if (c.getTipo().equals("Digital")){%>
                                    <td class="right"><%=c.getCatidad()%></td>
                                    <td><span class="right" ><%= c.getPrecio()%> €</span></td>
                                <%}else{%>
                                    <td class="right"><%=c.getCatidad()%></td>
                                    <td><span class="right" ><%= c.getPrecio()%> €</span></td>
                                    
                                   <!-- <td><input type="number" name="cant" id="cant" value="<%--=c.getCatidad()--%>"></td>
                                    <td><input type="number" name="pre" id="cant" value="<%--= c.getPrecio()--%>" hidden=""><span class="right" id="precio">€</span></td>-->
                                <%}%>
                                <td> <a onclick="msg('<%=c.getCodigoLibro()%>');" class="btn-floating red darken-1 right hoverable" ><i class="material-icons">delete</i>Eliminar</a>
                                   </td>
                            </tr>
                            
                            <%}%>
                        
                        </tbody>
                    </table>
                </div>
                <div class="card-content">
                    <!--<span><b>Descuento: 00,00 €</b></span><span id="dto"></span><br>-->
           
                    <br>
                    <p class="right-align"><B>TOTAL A PAGAR: </B><span class="preper"><%=total%> €</span></p>
               

                      <br>

                </div> 
                    
                    
                    
                    
                    <div class="card-content ">

                        <form class="card ref" action="FinalizarPago" method="post">


                    
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

                           <!-- <div class='row black-text' >
                                <button class=" col m6 s12 btn-large blue-grey darken-1 hoverable" type="button" onclick="window.location.href = 'ServletCompraCreaVende?nom=crear';" style="font-weight: bold">Cancelar compra</button>
                                <button class="col m6 s12 btn-large red hoverable" type="submit" style="font-weight: bold">Finalizar compra</button>
                            </div>-->
                            
                    <div class="row">
                   
                    
                    <button class="col l6 s12 m12 btn-large blue-grey darken-1 hoverable" type="button" onclick="window.location.href = 'ServletCompraCreaVende?nom=compra';" >Cancelar compra</button>
                    <button class="col l6 s12 m12 btn-large  hoverable red" type="submit" style="font-weight: bold" >Finalizar compra</button>
                    
                </div>

                        </form>
                    </div>
                    
                    
                    
                            
               
                  
        </div>
             
    </div>

            
</div>
<%}else{%>
....
<%}%>

<br><br>

<script>
    
     function msg(id){
            var opcion = confirm("Eliminar Articulo de la cesta \nDesea continuar");
            if (opcion == true) {
                //$('#cesta').remove();
                window.location.href ="BorrarElementoCesta?id="+id+"&cc=ccc";
                }
           }
    
    /*var pag;
    var can;
    var precio;
    var total;
    var totpag = 0;
    var subtotal = 0;*/
    
    
   /* $(document).ready(function () {
        precio = $("#pre").val();
        can = $("#can").val();
        pag = $("#pag").val();
        totpag = 0;
        if (pag > 50) {
            pag = pag - 50;
            totpag = pag * 0.02;
        }
        precio = parseFloat(precio) + parseFloat(totpag);
        $("#precio").html(precio.toFixed(2) + " €");
        subtotal = parseInt(can) * parseFloat(precio);
        total = subtotal.toFixed(2);
        $("#total").html(total + "€");

    });*/

    /*$("input").bind("keyup change", function () {

        precio = $("#pre").val();
        can = $("#can").val();
        pag = $("#pag").val();
        totpag = 0;
        if (pag > 50) {
            pag = pag - 50;
            totpag = pag * 0.02;
        }
        precio = parseFloat(precio) + parseFloat(totpag);
        $("#precio").html(precio.toFixed(2) + " €");
        subtotal = parseInt(can) * parseFloat(precio);
        total = subtotal.toFixed(2);
        $("#total").html(total + "€");
    });
    */
</script>