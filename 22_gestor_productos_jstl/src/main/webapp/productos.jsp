<%@page import="model.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Producto, java.util.List"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<h2>Productos de ${param.categoria} </h2>
	<table>
		<th>
			<td>Nombre</td>
			<td>Precio</td>
		</th>
	 	<c:forEach var="pr" items="${requestScope.productos}">
	 		<tr>
				<td>${pr.nombre}</td>
				<td>${pr.precio}</td>
			</tr>
	 	</c:forEach>
	</table>
	<a href="inicio.html">Volver a home</a>
</body>
</html> 

