package cloud.frizio.web.training.demojms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.frizio.web.training.demojms.queue.JBQWriter;

@SuppressWarnings("serial")
@WebServlet("/send")
public class SendMessageServlet extends HttpServlet {

  @Inject
  JBQWriter jbqueue;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String theMessage = (String) request.getParameter("msg");
    if ( theMessage != null && !theMessage.isEmpty() ) {
      jbqueue.sendMessage(theMessage);
      response.setContentType("text/html"); 
      PrintWriter printWriter = response.getWriter(); 
      printWriter.write( "Sent message: " + theMessage ); 
      printWriter.close(); 
    } else {
      response.sendError( HttpServletResponse.SC_BAD_REQUEST );
    }

  }

}
