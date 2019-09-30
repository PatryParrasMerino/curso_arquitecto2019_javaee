package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cierre")
public class Cierre extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//borramos cookie
		Cookie ck=new Cookie("usuario","");
		ck.setMaxAge(0);
		response.addCookie(ck);
		//destruimos sesión
		HttpSession sesion=request.getSession();
		sesion.invalidate();
		request.getRequestDispatcher("formulario.html").forward(request, response);
	
	}

}
