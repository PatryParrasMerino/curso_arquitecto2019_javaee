package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DaoContactos;
import factories.FactoryDao;
import model.Contacto;

/**
 * Servlet implementation class ContactosAction
 */
@WebServlet("/ContactosAction")
public class ContactosAction extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoContactos dao=FactoryDao.getDaoContactos();
		List<Contacto> contactos=dao.mostrarContactos();
		if(contactos!=null && contactos.size()>0) {
			request.setAttribute("resultado",1);
			request.setAttribute("contactos", contactos);
		}else {
			request.setAttribute("resultado",0);
		}
	}

}
