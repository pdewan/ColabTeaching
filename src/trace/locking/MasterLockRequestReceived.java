package trace.locking;

import trace.control.CommunicatedControlInfo;
import util.session.CommunicatorSelector;

public class MasterLockRequestReceived extends CommunicatedControlInfo{

	public MasterLockRequestReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public MasterLockRequestReceived(String aMessage, CommunicatedControlInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static MasterLockRequestReceived toTraceable (String aMessage) {
		CommunicatedControlInfo anInfo = CommunicatedControlInfo.toTraceable(aMessage);
		return new MasterLockRequestReceived(aMessage, anInfo);
	}
	public static MasterLockRequestReceived newCase(
			String aProcessName,
			 String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSourceOrDestination);
		MasterLockRequestReceived retVal = new MasterLockRequestReceived(aMessage, aProcessName, aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}
	public static MasterLockRequestReceived newCase(
			 String aSourceOrDestination, Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aSourceOrDestination, aFinder);
			
		
	}

	

}
