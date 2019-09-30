package escuchadores;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class EscuchadorSesion
 *
 */
@WebListener
public class EscuchadorSesion implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public EscuchadorSesion() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         ServletContext context=se.getSession().getServletContext();
         int activos=(Integer)context.getAttribute("activos");
         activos++;
         context.setAttribute("activos", activos);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	ServletContext context=se.getSession().getServletContext();
        int activos=(Integer)context.getAttribute("activos");
        activos--;
        context.setAttribute("activos", activos);
    }
	
}
