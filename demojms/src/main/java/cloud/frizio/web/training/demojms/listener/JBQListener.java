package cloud.frizio.web.training.demojms.listener;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:/jms/queue/javaboss"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class JBQListener implements MessageListener {

  /*
   * Metodo invocato dal container per il processamento del messaggio prelevato dalla coda
   */
  public void onMessage(Message message) {
    try {
      System.out.println( "Queue MDB: " + message.getBody( String.class ) );
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

}
