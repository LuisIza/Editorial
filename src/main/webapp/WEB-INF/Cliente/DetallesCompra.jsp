<%-- 
    Document   : DetallesCompra
    Created on : 07-may-2019, 16:11:37
    Author     : Luis
--%>

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.ArchivosCliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% PedidosImpresos libro =(PedidosImpresos) session.getAttribute("Carrito");

    if (libro != null) {
%>
<br>
<br><br><br><br><br><br><br><br>

<div class="row">
     <form method="POST" action="FinalizarCompraPersonalizado">
    <div class="col l8 offset-l2 m12">
 
        <div class="card">
          

                <div class="card-image">
                    <span class="titulocurso">Detalles de la Compra</span>
                </div>
                <div class="card-content">

                    <table class="striped ">
                        <thead class="">
                            <tr>
                                <th>Tipo</th>
                                <th>Codigo</th>
                                <th>Cantidad</th>
                                <th>Nº Paginas</th>
                                <th class="right">Precio Unitario</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td><img src="<%=request.getContextPath()%>/img/lb.jpg" alt="" class="circle responsive-img"></td>
                                <td><input type="text" name="codigo" id="codigo" value="<%= libro.getProducto()%>" hidden=""><%= libro.getProducto()%></td>
                                <td><input type="number" name="can" id="can" value="<%= libro.getCantidad()%>" size="5" maxlength="4"></td>
                                <td><input type="number" name="pag" id="pag" value="<%= libro.getPaginas()%>" size="5" maxlength="5"></td>
                                <td><input type="text" name="pre" id="pre" value="<%= libro.getPrecio()%>" hidden=""><span class="right" id="precio">€</span></td>
                            </tr>

                        </tbody>
                    </table>
                </div>
                <div class="card-content right">
                    <!--<span><b>Descuento: 00,00 €</b></span><span id="dto"></span><br>-->
           
                    <br>
                    <p><B>TOTAL A PAGAR: </B><span class="preper" id="total"></span></p>
                    <br>

                </div> 
                              <br>
        </div>
             
    </div>
   <div class="row">
                <div class=" col l6 m6 ">
                    <button class="btn-large blue-grey darken-1 right hoverable" type="button" onclick="window.location.href = 'ServletCompraCreaVende?nom=crear';" >Cancelar compra</button>
                </div>
                <div class=" col l6 m6">
                    <button class="btn-large blue-grey darken-1 hoverable" type="submit">Continuar</button>
                </div></div>
               </form>
</div>
<%}%>

<br><br>

<script>


    var pag;
    var can;
    var precio;
    var total;
    var totpag = 0;
    var subtotal = 0;
    $(document).ready(function () {
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

    $("input").bind("keyup change", function () {

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
</script>