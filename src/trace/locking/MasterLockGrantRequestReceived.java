package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class MasterLockGrantRequestReceived extends CommunicatedLockInfo{

	public MasterLockGrantRequestReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public MasterLockGrantRequestReceived(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static MasterLockGrantRequestReceived toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new MasterLockGrantRequestReceived(aMessage, anInfo);
	}
	public static MasterLockGrantRequestReceived newCase(
			String aProcessName,
			 String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSourceOrDestination);
		MasterLockGrantRequestReceived retVal = new MasterLockGrantRequestReceived(aMessage, aProcessName, aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}
	public static MasterLockGrantRequestReceived newCase(
			 String aSourceOrDestination, Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aSourceOrDestination, aFinder);
			
		
	}

	

}
