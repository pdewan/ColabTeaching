package im.access;

import echo.modular.SimpleList;
import im.AReplicatedHistory;
import im.AnIMClientComposerAndLauncher;
import im.ReplicatedHistory;
import im.aware.ASessionAwarenessProvider;
import im.aware.AnAwareIMComposerAndLauncher;
import util.session.Communicator;
import util.session.ReceivedMessageListener;
import util.session.SessionMessageListener;
import bus.uigen.ObjectEditor;

public class AnAccessControlledIMClientComposerAndLauncher extends AnIMClientComposerAndLauncher {	
	static String APPLICATION_NAME = "Access Controlled IM";	
	protected void addCollaborationFunctions() {
		super.addCollaborationFunctions();
		addAccessControl();	
	}
	protected SimpleList<String> createHistory() {
		return new AControlledReplicatedHistory<String>(communicator);
	}	
	public  void addAccessControl() {	
		AccessController accessController = new AnAccessController(communicator);		
		ReceivedMessageListener accessReceiver = new AnAccessReceiver(communicator, accessController);
		communicator.addReceivedMessageListener(accessReceiver);
//		controlledReplicatedHistory().addVetoer(accessController);
		controlledReplicatedHistory().addVetoableChangeListener(accessController);

		ObjectEditor.edit(accessController);

	}	
	protected ControlledReplicatedHistory<String> controlledReplicatedHistory() {
		return (ControlledReplicatedHistory<String>) history;
	}
	
	
}
