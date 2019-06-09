<%-- 
    Document   : gestionIO
    Created on : 15-dic-2018, 20:36:49
    Author     : LUIS
--%>
 

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.PedidosImpresos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<br>
 <br>
  <% List<PedidosImpresos> pedidos = (List<PedidosImpresos>) request.getAttribute("creacion");
  
    if (pedidos == null){%>
     <br> <br>
     <div class="row">
    <div class="col l10 offset-l1 s12 m10 offset-m1">
      <div class="card">
        
        <div class="card-content">
            <br>
            <h3>No ha realizado ninguna creación...</h3><br>
        </div>
      </div>
    </div>
     </div>
    <%}else{%>


  <br> <br>
 <div class="row">
    <div class="col l10 offset-l1 s12 m10 offset-m1">
      <div class="card">
        
        <div class="card-content">
            <h3 class="center-align">Historial de Pedidos realizados</h3>
            <table class="striped responsive-table">
        <thead>
          <tr class="blue-grey darken-2 white-text center-align">
              <th>Referencia</th>
              <th>Productos</th>
              <th>Fecha de pedido</th>
              <th>Precio</th>
              <th>Estado</th>
          </tr>
        </thead>
      
        <tbody>
        <%for (PedidosImpresos p : pedidos) {%>
          <tr>
           <td><%=p.getReferencia()%></td>
           <td><%=p.getProducto()%></td>
           <td><%=p.getFechaAlta()%></td>
            <td><%=p.getPrecio()%></td>
           <td><%=p.getEstado()%></td>
                        
               
            </td>
            <td>
               
            </td>
          </tr>
          <%}%>      
         
        </tbody>
      </table>
         
        </div>
      </div>
    </div>
  </div>
    <%}  %>
 
       
        <p>&nbsp;</p> 
        <p>&nbsp;</p>
         
