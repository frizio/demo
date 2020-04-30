package cloud.frizio.web.training.demojms.queue;


import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

@Singleton
public class JBQReader {

  @Resource(mappedName = "java:/jms/queue/javaboss")
  private Queue jbqueue;

  @Resource(mappedName = "java:/JmsXA")
  private ConnectionFactory connectionFactory;

  private Connection connection;


  public String readMessage() {
    try {
      connection = connectionFactory.createConnection();
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      MessageConsumer consumer = session.createConsumer(jbqueue);
      connection.start();
      Message message = consumer.receive(5000);  
      if ( message != null ) {
        return message.getBody(String.class);
      }
      return null;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (connection != null)   {
        try {
          connection.close();
        } catch (JMSException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

}

