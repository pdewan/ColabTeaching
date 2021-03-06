package im.centralized;

import im.AnIMClientComposerAndLauncher;
import util.session.Communicator;
import util.trace.Tracer;
import util.trace.session.SessionTracerSetter;
import echo.modular.SimpleList;
public class AMasterIMComposerAndLauncher extends AnIMClientComposerAndLauncher {
	
		
	protected SimpleList<String> createHistory() {
		return new AMasterSimpleList<String>(communicator);
	}
	// no UI, so no interactor
	protected void connectModelInteractor() {
		
	}
	// same reason as above, no input
	public void launch() {
	}
	@Override
//	protected  void addHistoryInCoupler(Communicator communicator, SimpleList<String> aHistory) {

	protected  void addHistoryInCoupler() {
		historyInCoupler = new AMasterInCoupler(history);
		communicator.addPeerMessageListener(historyInCoupler);
	}
	public static void main (String[] args) {
		Tracer.showInfo(true);
		SessionTracerSetter.setSessionPrintStatus();
		(new AMasterIMComposerAndLauncher()).composeAndLaunch(args);
	}
}
