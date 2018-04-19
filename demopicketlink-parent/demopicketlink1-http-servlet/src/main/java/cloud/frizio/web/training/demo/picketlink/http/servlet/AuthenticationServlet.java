package cloud.frizio.web.training.demo.picketlink.http.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author Pedro Igor
 */
@SuppressWarnings("serial")
@WebServlet ("/auth")
public class AuthenticationServlet extends HttpServlet {
	
	private static final Logger LOG4JLOGGER = LogManager.getLogger(AuthenticationServlet.class.getName());
	

    @Override
    protected void service(HttpServletRequest  request, 
    					   HttpServletResponse response) throws ServletException, IOException {
    	LOG4JLOGGER.info("Chiamato metodo service");
    	LOG4JLOGGER.info("request.getUserPrincipal() = " + request.getUserPrincipal());
    	LOG4JLOGGER.info("request.getContextPath() = " + request.getContextPath());
        if (isLogout(request)) {
            request.logout();
        }
        tryAuthentication(request);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
    

    private boolean isLogout(HttpServletRequest request) {
        return request.getUserPrincipal() != null && request.getParameter("logout") != null;
    }
    

    private void tryAuthentication(HttpServletRequest request) throws ServletException {
    	LOG4JLOGGER.info("Chiamato metodo tryAuthentication");
        try {
        	if (request.getUserPrincipal() == null) {
        		String username = request.getParameter("username");
        		String password = request.getParameter("password");
        		
        		if (username != null && password != null) {
        			request.login(username, password);
        		}			
        	}
		} catch (Exception e) {
			LOG4JLOGGER.info("ATTENZIONE: è stata sollevata un'eccezione! " + e.getMessage());
			LOG4JLOGGER.error(e);
			e.printStackTrace();
		}
    }
    
}
