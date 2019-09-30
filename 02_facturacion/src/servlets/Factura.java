package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Factura")
public class Factura extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String producto=request.getParameter("producto");
		int unidades=Integer.parseInt(request.getParameter("unidades"));
		double precio=Double.parseDouble(request.getParameter("precio"));
		int iva=Integer.parseInt(request.getParameter("iva"));
		out.println("</center></body></html>");
		out.println("Has comprado " +unidades+ " de "+producto);
		out.println("Total:" +unidades*precio*((100+iva)/100));
		out.close();
	}

}
