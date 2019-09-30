<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Persona"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Persona p=(Persona)request.getAttribute("persona"); %>
	Usuario:<%=p.getUsuario() %><br/>
	Email:<%=p.getEmail() %><br/>
	Edad:<%=p.getEdad() %><br/><br/>
	<br/>
	<a href='formulario.html'>volver</a>
	
</body>
</html>