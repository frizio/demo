package cloud.frizio.web.training.demojpa.util;

import java.util.logging.Logger;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class JsfLifecycleListener implements PhaseListener {

	private static final long serialVersionUID = 1L;
	
	private Logger LOGGER = Logger.getLogger(JsfLifecycleListener.class.getName());
	
	
	@Override
	public void afterPhase(PhaseEvent event) {
		LOGGER.info("afterPhase method: END PHASE " + event.getPhaseId() + "\n");
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		LOGGER.info("beforePhase method: START PHASE " + event.getPhaseId());
		if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {
			LOGGER.info("Siamo nella fase di RESTORE_VIEW");
		} else if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {
			LOGGER.info("Siamo nella fase di RENDER_RESPONSE");
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
