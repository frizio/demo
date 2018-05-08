package cloud.frizio.web.training.demojsf.model;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

@SessionScoped
@Named
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Logger LOGGER = Logger.getLogger(User.class.getName()); 

	private String email;

	
	//@Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$", message = "This is not a valid email")
	public String getEmail() {
		LOGGER.info("Chiamato metodo getEmail");
		return email;
	}
	public void setEmail(String email) {
		LOGGER.info("Chiamato metodo setEmail");
		this.email = email;
	}
	
}
