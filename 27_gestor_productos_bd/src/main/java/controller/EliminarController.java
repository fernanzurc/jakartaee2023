package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductosService;

import java.io.IOException;

@WebServlet("/EliminarController")
public class EliminarController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosService productosService=new ProductosService();
		productosService.eliminarPorNombre(request.getParameter("nombre"));
	}
}
