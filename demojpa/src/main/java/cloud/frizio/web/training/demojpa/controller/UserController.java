package cloud.frizio.web.training.demojpa.controller;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import cloud.frizio.web.training.demojpa.model.MyUser;

@Stateful
@ApplicationScoped
@Named
public class UserController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Logger LOGGER = Logger.getLogger(UserController.class.getName());
	
	@Inject
	EntityManager em;
	
	@PostConstruct
	public void init() {
		LOGGER.info("Creato oggetto UserController");
	}
	
	public void create()  {
		LOGGER.info("Creato Utente");
		MyUser user = new MyUser();
		user.setName("Maurizio");
		user.setEmail("aa@aa.com");
		em.persist(user);
	}
	
}
