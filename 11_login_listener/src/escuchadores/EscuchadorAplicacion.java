package escuchadores;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EscuchadorAplicacion
 *
 */
@WebListener
public class EscuchadorAplicacion implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        sce.getServletContext().setAttribute("activos", 0);
    }
	
}
