package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import beans.Producto;

/**
 * Application Lifecycle Listener implementation class EscuchadorSesion
 *
 */
@WebListener
public class EscuchadorSesion implements HttpSessionListener {

  

    public void sessionCreated(HttpSessionEvent se)  { 
         HttpSession sesion=se.getSession();
         sesion.setAttribute("carrito", new ArrayList<Producto>());
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
       
    }
	
}
