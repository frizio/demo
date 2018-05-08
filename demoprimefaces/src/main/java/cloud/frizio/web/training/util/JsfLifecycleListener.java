package cloud.frizio.web.training.util;

import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class JsfLifecycleListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	private Logger LOGGER = Logger.getLogger(JsfLifecycleListener.class.getName());

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	
	@Override
	public void beforePhase(PhaseEvent event) {
		LOGGER.info("JSF LIFECYCLE PHASE: " + event.getPhaseId() + " - BEGIN");
	}

	@Override
	public void afterPhase(PhaseEvent event) {
		LOGGER.info("JSF LIFECYCLE PHASE: " + event.getPhaseId() + " - END \n");
	}
	
}
