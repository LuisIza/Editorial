<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%  PedidosImpresos libro = (PedidosImpresos) session.getAttribute("Carrito");
    if (libro != null) {
%>
<br><br><br><br>
<br><br>


<div class="row">
    <div class="col l10 offset-l1">
        <div class="row">
            <div class="col l8 offset-l2 s12 m10 offset-m1">
                <div class="card">

                    <div class="card-content">
                         <h3>Pedido realizado correctamente</h3>
                        <p>La información sobre el metodo de pago, condiciones y devoluciones se han enviado a la direccion de correo electronico que nos han facilitado</p>
                        <p><b>Número de cuenta para la transferencia: </b> ES89 5849 8562 8745 0213</p>
                         <p><b>En el concepto indique la siguiente referencia: </b> REF-<%=libro.getReferencia()%></p>
                         <p><b>Condiciones del servicio:</b>
                             
                         <h4>Gracias por utilizar nuestros servicios.</h4>
                    </div>
                    <div class="card-action">

                           <button class=" col m6 s12 btn-large blue-grey darken-1 hoverable" type="button" onclick="window.location.href = 'IndexServlet';" style="font-weight: bold">Salir</button>                   
                    </div>
                         <br> <br> <br>
                </div> 

            </div>
        </div>
    </div>
</div>
<%}%>