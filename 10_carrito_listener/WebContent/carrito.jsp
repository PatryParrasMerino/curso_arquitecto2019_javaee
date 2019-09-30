<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,beans.Producto"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--
		recuperamos el carrito y si existe lo mostramos
	 --%>
	<%List<Producto> productos=(List<Producto>)session.getAttribute("carrito");
	if(productos.size()==0){%>
		<jsp:forward page="sincarrito.html"/>
		
	<%}else{%>
		<table border="1">
			<tr>
				<th>Nombre</th><th>Precio</th><th>Unidades</th>
			</tr>
			<%for(Producto producto:productos){ %>
				<tr>
					
					<td><%=producto.getNombre() %></td>
					<td><%=producto.getPrecio() %></td>
					<td><%=producto.getUnidades() %></td>
				</tr>
			
			<%} %>
		
		</table>
			
	<%}%>
	<br/>
	
	<a href="inicio.html">Inicio</a><br/>
	<a href="CerrarSesion">Cerrar sesión</a>
</body>
</html>