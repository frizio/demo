package cloud.frizio.web.training.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


//@ManagedBean
@SessionScoped
@Named()
public class BasicView implements Serializable {
     
	private static final long serialVersionUID = 1L;

	//private static final Logger LOGGER = Logger.getLogger(BasicView.class.getName());
	@Inject
	private transient Logger LOGGER;
	
	private String text;
 
	
	@PostConstruct
	public void init() {
		LOGGER.info("Il bean è stato creato dal container");
	}
	
	@PreDestroy
	public void finalize() {
		LOGGER.info("Il bean stà per essere distrutto dal container");
	}
	
	
    public String getText() {
    	LOGGER.info("Chiamato metodo getText() " + this.text);
        return text;
    }
    public void setText(String text) {
    	LOGGER.info("Chiamato metodo setText() " + text);
        this.text = text;
    }
    
}