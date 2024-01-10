package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UsuariosService;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuariosService service=new UsuariosService();
		/*if(service.autenticar(request.getParameter("usuario"), request.getParameter("password"))) {
			request.setAttribute("autenticado", true);
		}else {
			request.setAttribute("autenticado", false);
		}*/
		//el resultado de la autenticación lo guardamos en un atributo de petición
		//para que lo pueda utilizar el FC
		request.setAttribute("autenticado", service.autenticar(request.getParameter("usuario"), request.getParameter("password")));
	}

}
