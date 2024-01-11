package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import service.CursosService;

@WebServlet("/BuscarController")
public class BuscarController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CursosService service=new CursosService();
		ArrayList<Curso> cursos=service.preciosCursoMax(Double.parseDouble(request.getParameter("precio")));
		//guardamos ArrayList en atributo de petición antes
		//de transferir petición al JSP
		request.setAttribute("cursos", cursos);
		
	}

}
