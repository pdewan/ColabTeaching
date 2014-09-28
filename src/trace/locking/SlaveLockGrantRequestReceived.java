package trace.locking;

import trace.control.CommunicatedControlInfo;
import util.session.CommunicatorSelector;

public class SlaveLockGrantRequestReceived extends CommunicatedControlInfo{

	public SlaveLockGrantRequestReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveLockGrantRequestReceived(String aMessage, CommunicatedControlInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveLockGrantRequestReceived toTraceable (String aMessage) {
		CommunicatedControlInfo anInfo = CommunicatedControlInfo.toTraceable(aMessage);
		return new SlaveLockGrantRequestReceived(aMessage, anInfo);
	}
	public static SlaveLockGrantRequestReceived newCase(
			String aProcessName,
			 String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSourceOrDestination);
		SlaveLockGrantRequestReceived retVal = new SlaveLockGrantRequestReceived(aMessage, aProcessName, aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveLockGrantRequestReceived newCase(
			 String aSourceOrDestination, Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aSourceOrDestination, aFinder);
			
		
	}

	

}
