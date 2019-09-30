package servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Megusta
 */
@WebServlet("/Megusta")
public class Megusta extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context=request.getServletContext();
		int contador=0;
		if(context.getAttribute("megusta")!=null) {
			contador=(Integer)context.getAttribute("megusta");
		}
		contador++;
		context.setAttribute("megusta", contador);
		request.getRequestDispatcher("opciones.html").forward(request, response);
	}

}
