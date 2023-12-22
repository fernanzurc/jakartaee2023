<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="CerrarSesionServlet">Cerrar sesión</a>
	<center>
		<%List<Producto> carrito=(List<Producto>)session.getAttribute("carrito");
		if(carrito!=null){%>
		
			<table border="1">
			
				<tr><th>Nombre</th><th>Precio</th><th>Categoria</th><th></th></tr>
				<%for(Producto pr:carrito){%>
					<tr>
						<td><%=pr.getNombre()%></td>
						<td><%=pr.getPrecio()%></td>
						<td><%=pr.getCategoria()%></td>
						<td><a href="EliminarCarritoServlet?nombre=<%=pr.getNombre()%>">Eliminar</a></td>
					</tr>
				
				<%} %>
			
			</table>
			
		
		<%}%>
		<br><br>
		<a href="menu.html">volver</a>
	</center>
</body>
</html>