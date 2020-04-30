package cloud.frizio.web.training.demojms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cloud.frizio.web.training.demojms.queue.JBQReader;

@SuppressWarnings("serial")
@WebServlet("/read")
public class ReadMessageServlet extends HttpServlet {

  @Inject
  JBQReader qbqueue;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String theMessage;
    theMessage = qbqueue.readMessage();
    response.setContentType("text/html"); 
    PrintWriter printWriter = response.getWriter(); 
    if (theMessage != null && !theMessage.isEmpty()) {
      printWriter.write( "Received message: " + theMessage ); 
    } else {
      printWriter.write( "Nothing to read ..." ); 
    }
    printWriter.close();
  }
  
}
