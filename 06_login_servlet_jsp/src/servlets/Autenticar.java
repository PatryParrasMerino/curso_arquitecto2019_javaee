package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Persona;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/Autenticar")
public class Autenticar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		RequestDispatcher rd;
		if(user.equals("admin")&&pwd.equals("admin")) {
		
			Persona p = new Persona(user,"prueba",44);			
			request.setAttribute("persona", p);
			
			rd=request.getRequestDispatcher("ok.jsp");
			rd.forward(request, response);
		}else {
			rd=request.getRequestDispatcher("nop.jsp");
			//response.sendRedirect("http://www.google.es");
			//response.sendRedirect("Error");   // pierde los parametros porque es una llamada distinta
			//response.sendRedirect("Error?user="+user+"&pwd="+pwd);    //se fuerza para coger los parametros
		}
		
		
	}

	
}
