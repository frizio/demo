package cloud.frizio.web.training.demojpa.util;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class Resources {

	@Produces
	@PersistenceContext(unitName="demojpaPU")
	private EntityManager entityManager;
	
}
