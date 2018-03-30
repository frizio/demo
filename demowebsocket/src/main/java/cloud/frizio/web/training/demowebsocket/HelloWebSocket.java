package cloud.frizio.web.training.demowebsocket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/echo")
public class HelloWebSocket {
	
	private static final Logger LOGGER = Logger.getLogger(HelloWebSocket.class.getName());
	

	/**
     * @OnOpen allows us to intercept the creation of a new session.
     * The session class allows us to send data to the user.
     * In the method onOpen, we'll let the user know that the handshake was 
     * successful.
     */
    @OnOpen
    public void onOpen(Session session){
    	LOGGER.log(Level.INFO, session.getId() + " has opened a connection"); 
        try {
            session.getBasicRemote().sendText("Connection Established");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    /**
     * When a user sends a message to the server, this method will intercept the message
     * and allow us to react to it. 
     * For now the message is read as a String.
     */
    @OnMessage
    public void onMessage(String message, Session session){
    	LOGGER.log(Level.INFO, "Message from " + session.getId() + ": " + message);
    	// Processing message and send response to the client.
    	String processedMessage = message.toUpperCase();
        try {
            session.getBasicRemote().sendText(processedMessage);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * The user closes the connection.
     * 
     * Note: you can't send messages to the client from this method
     */
    @OnClose
    public void onClose(Session session){
    	LOGGER.log(Level.INFO, "Session " +session.getId()+" has ended");
    }
    
   
}
