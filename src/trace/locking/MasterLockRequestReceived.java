package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class MasterLockRequestReceived extends CommunicatedLockInfo{

	public MasterLockRequestReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public MasterLockRequestReceived(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static MasterLockRequestReceived toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
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
