<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="CerrarSesionServlet">Cerrar sesión</a>
	<center>
		
		<c:if test="${!empty sessionScope.carrito}">
			<table border="1">
			
				<tr><th>Nombre</th><th>Precio</th><th>Categoria</th><th></th></tr>
				
				<c:forEach var="pr" items="${sessionScope.carrito}">
					<tr>
						<td>${pr.nombre}</td>
						<td>${pr.precio}</td>
						<td>${pr.categoria}</td>
						<td><a href="EliminarCarritoServlet?nombre=${pr.nombre}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>		
		</c:if>
		<br><br>
		<a href="menu.html">volver</a>
	</center>
</body>
</html> 