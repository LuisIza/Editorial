<%-- 
    Document   : gestionIO
    Created on : 15-dic-2018, 20:36:49
    Author     : LUIS
--%>
 

<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<br>
 <br>

 <div class="row">
    <div class="col l8 offset-l2 s12 m10 offset-m1">
      <div class="card">
        
        <div class="card-content">
            <h3>Registro de Usuarios</h3>
            <table class="striped">
        <thead>
          <tr>
              <th>Nombre Usuario</th>
              <th>Datos</th>
              <th>Administrar</th>
          </tr>
        </thead>
        <%List<UsuariosEa> reg = (List<UsuariosEa>) request.getAttribute("registro");%>
        <tbody>
        <%for (UsuariosEa r : reg) { %>
          <tr>
           <td><%=r.getNombre()%></td>
                        
            <td>Correo: <%=r.getEmail()%>
                <br>Permisos: <%=r.getPermisos()%>
            </td>
            <td>
                <a class="btn-floating blue-grey darken-1" href="BotonEditarUser?id=<%=r.getEmail()%>"><i class="material-icons">edit</i>Modificar</a>&nbsp;&nbsp;
                <a onclick="msg('<%=r.getEmail()%>');" class="btn-floating red darken-1 " ><i class="material-icons">delete</i>Eliminar</a>
            </td>
          </tr>
          <%}%>      
         
        </tbody>
      </table>
         
        </div>
      </div>
    </div>
  </div>

        <script type="text/javascript">
    
           function msg(id){
            var opcion = confirm("Eliminar usuario \nDesea continuar");
            if (opcion == true) {
                window.location.href ="BotonBorrarUser?id="+id;
                }
           }

        </script>
       
        <p>&nbsp;</p> 
        <p>&nbsp;</p>
         
