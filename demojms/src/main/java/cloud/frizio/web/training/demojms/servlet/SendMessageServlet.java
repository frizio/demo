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
import cloud.frizio.web.training.demojms.topic.JBTWriter;

@SuppressWarnings("serial")
@WebServlet("/send")
public class SendMessageServlet extends HttpServlet {

  @Inject
  JBQWriter jbqueue;
  
  @Inject
  JBTWriter jbtopic;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String theMessage = (String) request.getParameter("msg");
    String theType = (String) request.getParameter("type");
    if ( theMessage != null && !theMessage.isEmpty() ) {
      this.send(theMessage, theType);
      response.setContentType("text/html");
      PrintWriter printWriter = response.getWriter(); 
      printWriter.write( "Sent message: " + theMessage + " with type: " + theType ); 
      printWriter.close(); 
    } else {
      response.sendError( HttpServletResponse.SC_BAD_REQUEST );
    }
  }

  private void send( String msg, String type ) {
    if ( type.endsWith("queue") ) {
      jbqueue.sendMessage(msg);
    } else if ( type.endsWith("topic1") ) {
      jbtopic.sendMessage(msg, 1);
    } else {
      jbtopic.sendMessage(msg, 2);
    }
  }

}
