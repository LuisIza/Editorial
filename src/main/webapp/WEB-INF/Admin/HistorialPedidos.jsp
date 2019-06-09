<%-- 
    Document   : gestionIO
    Created on : 15-dic-2018, 20:36:49
    Author     : LUIS
--%>
 

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.LibroPublicadoEa"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.HistorialCompras"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<br>
 <br>
  <% List<HistorialCompras> his = (List<HistorialCompras>) request.getAttribute("historial");
  
    if (his == null){%>
     <br> <br>
     <div class="row">
    <div class="col l10 offset-l1 s12 m10 offset-m1">
      <div class="card">
        
        <div class="card-content">
            <br>
            <h3>No ha realizado ninguna compra...</h3><br>
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
        <%for (HistorialCompras r : his) {
        LibroPublicadoEa lib = r.getProductoId();%>
          <tr>
           <td><%=r.getReferencia()%></td>
           <td><%=lib.getNombreLibro()%></td>
           <td><%=r.getFecha()%></td>
            <td><%=r.getPrecioTotal()%></td>
           <td><%=r.getEstado()%></td>
                        
               
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
         
