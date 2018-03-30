package cloud.frizio.web.training.demolog4j;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns="/demo")
public class DemoServletLog4j extends HttpServlet {

	private static final long serialVersionUID = 1L;

	//private static final Logger LOG4JLOGGER = LogManager.getLogger(DemoServletLog4j.class.getName());
	private static final Logger LOG4JLOGGER = Logger.getLogger(DemoServletLog4j.class.getName());
	
	// @Inject private transient Logger LOG4JLOGGER;

	@Override
	public void init() throws ServletException {
		super.init();
		LOG4JLOGGER.info("Servlet initialized.");
		LOG4JLOGGER.info("User home = " + System.getProperty("user.home"));
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		LOG4JLOGGER.info("service() method called.");
	}

	@Override
	public void destroy() {
		super.destroy();
		LOG4JLOGGER.info("Servlet destroyed.");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//super.doGet(req, resp);
		LOG4JLOGGER.info("GET mathod called.");

		resp.setContentType("text/html");
		Writer w = resp.getWriter();
		w.write("<h2>Esempio di funzionamento di una servlet</h2>");
		w.flush();
		w.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOG4JLOGGER.info("POST method called.!");
		Writer w = resp.getWriter();
		w.write("Post request perfomed!\n");
		w.flush();
		w.close();
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOG4JLOGGER.info("PUT method called.");
		Writer w = resp.getWriter();
		w.write("Put request perfomed!\n");
		w.flush();
		w.close();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOG4JLOGGER.info("DELETE method called.");
		Writer w = resp.getWriter();
		w.write("Delete request perfomed!\n");
		w.flush();
		w.close();
	}


}
