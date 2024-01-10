package intercepting;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class FiltroLogin
 */
public class FiltroLogin extends HttpFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//si el usuario está autenticado (existe el atributo de sesión usuario)
		//le dejamos pasar, sino le mandamos a la página de login.html
		HttpSession sesion=((HttpServletRequest)request).getSession();
		String usuario=(String)sesion.getAttribute("usuario");
		if(usuario!=null) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			//obtenemos la dirección de entrada
			//String path=((HttpServletRequest)request).getServletPath();
			String param=((HttpServletRequest)request).getParameter("operation");
			if(param!=null&&param.equals("doLogin")) {
				chain.doFilter(request, response);
			}
			request.getRequestDispatcher("login").forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
