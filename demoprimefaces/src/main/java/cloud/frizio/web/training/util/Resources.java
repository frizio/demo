package cloud.frizio.web.training.util;

import java.util.logging.Logger;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

@Dependent
public class Resources {

	private static final Logger LOGGER = Logger.getLogger(Resources.class.getName());
	
	@Produces
	public Logger produceLogger(InjectionPoint injectionPoint) {
		LOGGER.info("Chiamato metodo produceLogger con inject " + injectionPoint.getBean().getName());
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
	
	/*
	@Produces
	FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	*/
	
}
