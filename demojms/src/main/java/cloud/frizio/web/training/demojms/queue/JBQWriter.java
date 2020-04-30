package cloud.frizio.web.training.demojms.queue;

import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/*
 * Classe per l’invio di messaggi verso la coda JBQ come EJB di tipo singleton
 */
@Singleton
public class JBQWriter {

  @Resource(name = "java:/jms/queue/javaboss")
  private Queue jbqueue;

  @Resource(mappedName = "java:/JmsXA")
  private ConnectionFactory connectionFactory;

  private Connection connection;

  public void sendMessage(String text) {
    try {
      connection = connectionFactory.createConnection();
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      MessageProducer publisher = session.createProducer(jbqueue);
      connection.start();
      TextMessage message = session.createTextMessage(text);
      publisher.send(message);
    } catch (Exception exc) {
        exc.printStackTrace();
    } finally {
        if (connection != null)   {
            try {
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
  }

}
