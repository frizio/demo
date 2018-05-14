package cloud.frizio.web.training.demojpa.service;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cloud.frizio.web.training.demojpa.model.MyUser;

/*
 * Dao for entity myuser
 * CRUD operations:
 * CREATE
 * READ
 * UPDATE
 * DELETE
 * 
 */
@Stateless
public class MyUserService {
	
	@Inject
	private transient Logger LOGGER;

	@Inject
	EntityManager entityManager;
	
	@PostConstruct
	public void init() {
		LOGGER.info("Creato DAO MyUserService");
	}
	
	@PreDestroy
	public void finalize() {
		LOGGER.info("Sessione scaduta o invalidata. Distruzione oggetto MyUserService");
	}
	

	public void create(MyUser myUser) {
		LOGGER.info("Inserimento (persist) utente nel database"); 
		entityManager.persist(myUser);	
		return;
	}
	
	public MyUser read(Integer valueOf) {
		LOGGER.info("Recupero (find) utente dal database"); 
		return entityManager.find(MyUser.class, valueOf);
	}
	
	public List<MyUser> readAll() {
		LOGGER.info("Recupero (select) utenti dal database"); 
		String sql = "SELECT p FROM myuser p";
		TypedQuery<MyUser> query = entityManager.createQuery(sql, MyUser.class); 
		List<MyUser> result = query.getResultList();
		return result;
		
		/*
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyUser> criteriaQuery = criteriaBuilder.createQuery(MyUser.class);
		Root<MyUser> from = criteriaQuery.from(MyUser.class);
		CriteriaQuery<MyUser> orderby = criteriaQuery.orderBy(criteriaBuilder.asc(from.get("email")));
		TypedQuery<MyUser> query = entityManager.createQuery(orderby);
		List<MyUser> resultList = query.getResultList();
		return resultList;
		*/
	}
	
	public void update(MyUser myuser) {
		LOGGER.info("Aggiornamento (marge) utente nel database");
		entityManager.merge(myuser);
	}

	public void delete(MyUser myuser) {
		LOGGER.info("Cancellazione (find + remove) utente nel database");
		MyUser p = entityManager.find(MyUser.class, myuser.getId());
		entityManager.remove(p);
		return;
	}
	
}
