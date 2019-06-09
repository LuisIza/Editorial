<%-- 
    Document   : home
    Created on : 30-nov-2018, 17:32:52
    Author     : LUIS
--%>


<%@page import="com.mycompany.editorialaragon.datamodel.entidades.ProductosEa"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.editorialaragon.controlador.CRUD.CrearLibroCRUD"%>
<%@page import="com.mycompany.editorialaragon.datamodel.entidades.UsuariosEa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% UsuariosEa login = (UsuariosEa) session.getAttribute("login");
    if (login == null) {
    } else {%>
<br>
<%}%>

<br> <br> <br>

<%  List<ProductosEa> precios = CrearLibroCRUD.showPrecios();
    for (ProductosEa p : precios){%>
    <input  type="text"  id="<%=p.getId()%>" value="<%=p.getPrecio()%>" hidden >
<%}%>


<div class="container">
        <!-- Page Content goes here -->
        <div class="row">
        	<div class="col l4 m4 s10 offset-s1" id ="tpn">
        		<div class="card blue-grey lighten-3" >
        			<span class="tit">Tapa Normal</span>
			        <div class="card-content white-text teal lighten-1" id ="tpn1">
			         <img class="imginfo" src="<%=request.getContextPath()%>/img/libroT.jpg">
			          <p>I am a very simple card. I am good at containing small bits of information.
			          I am convenient because I require little markup to use effectively.</p>
			        </div>

      			</div>
        	</div>
       	<div class="col l4 m4 s10 offset-s1" id ="tpp">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Tapa Premium</span>
			        <div class="card-content white-text" id ="tpp1">
			          <img class="imginfo" src="<%=request.getContextPath()%>/img/libroT.jpg">
			          <p>I am a very simple card. I am good at containing small bits of information.
			          I am convenient because I require little markup to use effectively.</p>
			        </div>

      			</div>
        	</div>

       	<div class="col l4 m4 s6">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Tamaño</span>
			        <div class="card-content white-text">
			        	<select class="browser-default" name="tam" id="tam" required>
			        		<option value="1" selected>A4</option>
			        		<option value="2">A5</option>
			        		<option value="3">Libro de bolsillo</option>
			        	</select>
			        </div>

      			</div>
        	</div>

       	<div class="col l4 m4 s6">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Calidad</span>
			        <div class="card-content white-text">
			        	<select class="browser-default" name="cal" id="cal" required>
			        		<option value="1" selected>Normal</option>
			        		<option value="2" disabled>Premium</option>
			        		
			        	</select>
			        </div>

      			</div>
        	</div>

       	<div class="col l4 m4 s6">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Color</span>
			        <div class="card-content white-text">
			        	<select class="browser-default" name="col" id="col" required>
			        		<option value="1" selected>Blanco/Negro</option>
			        		<option value="2" disabled>Color</option>
			        	</select>
			        </div>

      			</div>
        	</div>


        	         	<div class="col l4 m4 s6">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Encuadernado</span>
			        <div class="card-content white-text">
			        	<select class="browser-default" name="enc" id="enc" required>
			        		<option value="1" selected>Pegado</option>
			        		<option value="2" disabled>Espiral</option>
			        	</select>
			        </div>

      			</div>
        	</div>


        </div>

        <form action="ServletCarrito" method="POST">
         
            <input type="text" name="cod" id="cod" value="L11111" hidden>
            <div class="row">
             

             
           	<div class="col l3 m4 s4">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Páginas</span>
			        <div class="card-content white-text">
			        	<input  type="number" value="50" id="pag" name="pag" min="1">
			        </div>

      			</div>
        	</div>
        	    <div class="col l3 m4 s4">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Cantidad</span>
			        <div class="card-content white-text">
			        	<input type="number" value="1" name="can" id="can" min="1" max="1000" />
			        </div>

      			</div>
        	</div>
        	      <div class="col l3 m4 s4">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Precio Unitario</span>
			        <div class="card-content white-text">
                                    <span class="preper" id="precio"></span><br><br>
			        </div>

      			</div>
        	</div>
        	     <div class="col l3 m12 s12 ">
        		<div class="card blue-grey lighten-3">
        			<span class="tit">Comprar</span>
			        <div class="card-content white-text">
			        	<p class="preper" id="total">€
                                            
			        	</p>
			     
			        	<br>
                                        <button type="submit" class="col l12 waves-effect waves-light red darken-1 btn"><i class="material-icons right">shopping_cart</i>Comprar</button>
			        </div>
			       	<div class="card-action">
	        			
	          		
	        		</div>
      			</div>
        	</div>

         </div>
                                  </form>

    </div>


<script type="text/javascript">
    
	var tapa=1;
	var cal;
	var col;
	var enc;
        var pag;
        var can;
	var codigo = "L11111";
        var precio;
        var total;
        var subtotal=0;
        var dc=0;
        
    $(document).ready(function() {
                codigo = "L11111";
                tapa = 1;
                pag = 50;
		precio = $("#"+codigo).val();
		$("#precio").html(precio +" €");
                $("#total").html(precio+" €");
              
    });
    
	$("#tpn").click(function(){
		$("#tpn1").addClass("teal lighten-1");
		$("#tpp1").removeClass("teal lighten-1");
                $("#pag").val(50);
		$("#can").val(1);
		tapa = 1;
                pag = 50;
                subtotal = 0;
		tam = $("#tam").val();
		cal = $("#cal").val();
		col = $("#col").val();
		enc = $("#enc").val();
                can = 1;
		codigo= "L"+tapa+enc+tam+cal+col;
                precio = $("#"+codigo).val();
                precio = parseFloat(precio) + parseFloat(subtotal);
		dc = precio.toFixed(2);
		$("#precio").html(dc +" €");
                total = can *parseFloat(precio);
                dc= total.toFixed(2);
                $("#total").html(dc+" €");
               
	});		

	$("#tpp").click(function(){
		$("#tpp1").addClass("teal lighten-1");
		$("#tpn1").removeClass("teal lighten-1");
		$("#pag").val(50);
		$("#can").val(1);
		tapa = 2;
                pag = 50;
                can = 1;
                subtotal = 0;
		tam = $("#tam").val();
		cal = $("#cal").val();
		col = $("#col").val();
		enc = $("#enc").val();
		codigo= "L"+tapa+enc+tam+cal+col;
                precio = $("#"+codigo).val();
                precio = parseFloat(precio) + parseFloat(subtotal);
		dc = precio.toFixed(2);
		$("#precio").html(dc +" €");
                total = can *parseFloat(precio);
                dc= total.toFixed(2);
                $("#total").html(dc+" €"); 
	});	

	$("#tam").change(function(){
                
                tam = $("#tam").val();
		cal = $("#cal").val();
		col = $("#col").val();
		enc = $("#enc").val();
		codigo= "L"+tapa+enc+tam+cal+col;
		precio = $("#"+codigo).val();
                precio = parseFloat(precio) + parseFloat(subtotal);
		dc = precio.toFixed(2);
		$("#precio").html(dc +" €");
                total = can *parseFloat(precio);
                dc= total.toFixed(2);
                $("#total").html(dc+" €");
                $("#cod").val(codigo);
	});
        
         $("#can , #pag").bind("keyup change",function(){
                pag = $("#pag").val();
                subtotal=0;
                if (pag > 50){
                    pag = pag -50;
                    subtotal = pag * 0.02;
                }
                can = $("#can").val();
		precio = $("#"+codigo).val();
                precio = parseFloat(precio) + parseFloat(subtotal);
                dc = precio.toFixed(2);
		$("#precio").html(dc+" €");
                total = can *parseFloat(precio);
                dc= total.toFixed(2);
                $("#total").html(dc+" €");
               
        });
        
 

</script>