package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductosService;

@WebServlet("/AltaProductoServlet")
public class AltaProductoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService productosService=new ProductosService();
		productosService.agregarProducto(request.getParameter("nombre"), 
				Double.parseDouble(request.getParameter("precio")), 
				request.getParameter("categoria"));
		request.getRequestDispatcher("inicio.html").forward(request, response);
	}

}
