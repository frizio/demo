package cloud.frizio.web.training.demoprimefaces.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class ListenerView implements Serializable {
     
	private static final long serialVersionUID = 1L;
	
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
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    
    
    public void handleKeyEvent() {
    	LOGGER.info("Chiamato metodo handleKeyEvent " + this.text);
        text = text.toUpperCase();
    }
}
