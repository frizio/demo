package cloud.frizio.web.training.demo.picketlink.http.security;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

import javax.enterprise.event.Observes;

/**
 * @author Pedro Igor
 */
public class HttpSecurityConfiguration {
	
	private static final Logger LOG4JLOGGER = LogManager.getLogger(HttpSecurityConfiguration.class.getName());
	
    /**
     * <p>
     * Tells PicketLink to listen for all paths of the application. 
     * Please, notice that no security policy was defined
     * such as authentication or authorization. 
     * We're just enabling the PicketLink Security Filter.
     * </p>
     *
     * @param event
     */
    public void onInit(@Observes SecurityConfigurationEvent event) {
    	LOG4JLOGGER.info("\nChiamato metodo onInit");
    	LOG4JLOGGER.info("Osservato evento di tipo SecurityConfigurationEvent di Picketlink");
    	SecurityConfigurationBuilder builder = event.getBuilder();
        builder.http().allPaths();
    }
}
