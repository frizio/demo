package cloud.frizio.web.training.demojpa.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.registry.infomodel.User;

import cloud.frizio.web.training.demojpa.data.UserData;
import cloud.frizio.web.training.demojpa.model.MyUser;
import cloud.frizio.web.training.demojpa.service.MyUserService;


@SessionScoped
@Named
public class UserController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private transient Logger LOGGER;
	
	@Inject
	MyUserService dao;
	
	
	@Inject
	private UserData userData;


	@PostConstruct
	public void init() {
		LOGGER.info("Creato oggetto UserController");
	}
	
	@PreDestroy
	public void finalize() {
		LOGGER.info("Sessione scaduta o invalidata. Distruzione oggetto UserController");
	}
	
	
	public void creating()  {
		LOGGER.info("Creazione utente");
		MyUser user = new MyUser();
		user.setName(userData.getName());
		user.setEmail(userData.getEmail());
		dao.create(user);
	}
	
	public MyUser reading() {
		LOGGER.info("Recupero utente");
		MyUser myUser = dao.read(userData.getId());
		if (myUser != null) {
			LOGGER.info(myUser.toString());
		} else {
			LOGGER.warning("Utente non presente nel database");
		}
		return myUser;
	}
	
	public List<MyUser> readingAll() {
		LOGGER.info("Recupero utenti");
		List<MyUser> myUsers = dao.readAll();
		//LOGGER.info(myUsers.toString());
		return myUsers;
	}
	
	public void updating() {
		LOGGER.info("Aggiornamento utente");
		MyUser myUser = dao.read(userData.getId());
		if (myUser != null) {
			myUser.setEmail("bbb@bbb.com");
			dao.update(myUser);
		} else {
			LOGGER.warning("Utente non presente nel database");
		}
		
	}
	
	public void deleting() {
		LOGGER.info("Cancellazione utente");
		MyUser myUser = dao.read(userData.getId());
		if (myUser != null) {
			dao.delete(myUser);			
		} else {
			LOGGER.warning("Utente non presente nel database");
		}
	}

}

