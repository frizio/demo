package cloud.frizio.web.training.demojms.listener;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/topic/javaboss"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
        @ActivationConfigProperty(propertyName = "messageSelector",propertyValue = "type = 1")
    })
public class JBTListenerTypeOne implements MessageListener {

  public void onMessage(Message message) {
    try {
      System.out.println( "Type One MDB: " + message.getBody( String.class ) );
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

}
