package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bienvenida
 */
@WebServlet("/Error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //tipo de formato de respuesta
		PrintWriter out=response.getWriter(); //construimos página de respuesta
		out.println("<html><body>");
		out.println("<h1>Error el usuario "+request.getParameter("user")+" con contraseña");
		out.println(request.getParameter("pwd")+" no está registrado</h1>");
		out.println("<br/>");
		out.println("<a href='formulario.html'>volver</a>");
		out.println("</body></html>");
	}

}
