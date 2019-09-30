package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Producto;


@WebServlet("/servlet")
public class Servlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto producto = new Producto();
		RequestDispatcher rd;
		HttpSession sesion=request.getSession();
		sesion.setAttribute("Producto",producto);
		rd=request.getRequestDispatcher("VerCarrito.jsp");
		rd.forward(request, response);
	}

}
