package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import model.Producto;

@WebServlet("/AgregarCarritoServlet")
public class AgregarCarritoServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion=request.getSession();
		List<Producto> productos=new ArrayList<>();
		if(sesion.getAttribute("carrito")!=null) {
			productos=(List<Producto>)sesion.getAttribute("carrito");
		}
		productos.add(new Producto(request.getParameter("nombre"),
				Double.parseDouble(request.getParameter("precio")),
				request.getParameter("categoria")));
		sesion.setAttribute("carrito", productos);
		request.getRequestDispatcher("menu.html").forward(request, response);
	}

}
