package cloud.frizio.web.training.demojpa.data;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@RequestScoped
@Named
public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private transient Logger LOGGER;
	
	private int id;
	private String name;
	private String email;
	private int eta;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getEta() {
		return eta;
	}
	public void setEta(int eta) {
		this.eta = eta;
	}

	
	@PostConstruct
	public void init() {
		LOGGER.info("Creato oggetto " + UserData.class.getName());
		this.id = 1;
	}
	
	@PreDestroy
	public void finalize() {
		LOGGER.info("Distruzione oggetto UserController " + UserData.class.getName());
	}
	
	
}

