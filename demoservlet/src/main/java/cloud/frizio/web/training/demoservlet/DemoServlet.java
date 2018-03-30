package cloud.frizio.web.training.demoservlet;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = Logger.getLogger(DemoServlet.class.getName());
	
	// @Inject private transient Logger LOGGER;

	@Override
	public void init() throws ServletException {
		super.init();
		LOGGER.info("Servlet initialized.");
		LOGGER.info("User home = " + System.getProperty("user.home"));
		
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		LOGGER.info("service() method called.");
	}

	@Override
	public void destroy() {
		super.destroy();
		LOGGER.info("Servlet destroyed.");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		//super.doGet(req, resp);
		LOGGER.info("GET mathod called.");

		resp.setContentType("text/html");
		Writer w = resp.getWriter();
		w.write("<h2>Esempio di funzionamento di una servlet</h2>");
		w.flush();
		w.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOGGER.info("POST method called.!");
		Writer w = resp.getWriter();
		w.write("Post request perfomed!\n");
		w.flush();
		w.close();
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOGGER.info("PUT method called.");
		Writer w = resp.getWriter();
		w.write("Put request perfomed!\n");
		w.flush();
		w.close();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		LOGGER.info("DELETE method called.");
		Writer w = resp.getWriter();
		w.write("Delete request perfomed!\n");
		w.flush();
		w.close();
	}


}
