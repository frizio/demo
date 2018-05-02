package cloud.frizio.demo.web.training.listener;

import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class LifeCycleListener implements PhaseListener {

	private Logger LOGGER = Logger.getLogger(LifeCycleListener.class.getName());
	
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		LOGGER.info("START PHASE " + event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		LOGGER.info("END PHASE " + event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
		
	}

}
