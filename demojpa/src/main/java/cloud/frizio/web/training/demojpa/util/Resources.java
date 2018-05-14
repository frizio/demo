package cloud.frizio.web.training.demojpa.util;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Dependent
public class Resources {

	@Produces
	@PersistenceContext(unitName="demojpaPU")
	private EntityManager entityManager;
	
	
	@Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
	
	@Produces
    public FacesContext produceFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
