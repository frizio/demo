package cloud.frizio.web.demo.mvc.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testDbServlet")
public class TestDbServlet extends HttpServlet {

  private static final long serialVersionUID = -7498361863619072812L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String user = "wildfly_user";
    String password = "password1;";
    String url  = "jdbc:mysql://db:3306/test?useSSL=false&serverTimezone=UTC";

    String driver = "com.mysql.cj.jdbc.Driver";

    PrintWriter out = resp.getWriter();
    try {

      out.println("Connecting to db: " + url);
      Class.forName(driver);
      Connection connection = DriverManager.getConnection(url, user, password);
      out.println("Successful Connection.");
      connection.close();

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }

    //super.doGet(req, resp);
  }
  
}
