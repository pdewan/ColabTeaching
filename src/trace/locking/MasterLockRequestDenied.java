package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class MasterLockRequestDenied extends CommunicatedLockInfo{

	public MasterLockRequestDenied(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public MasterLockRequestDenied(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static MasterLockRequestDenied toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new MasterLockRequestDenied(aMessage, anInfo);
	}
	public static MasterLockRequestDenied newCase(
			String aProcessName,
			 String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSourceOrDestination);
		MasterLockRequestDenied retVal = new MasterLockRequestDenied(aMessage, aProcessName, aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}
	public static MasterLockRequestDenied newCase(
			 String aSourceOrDestination, Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aSourceOrDestination, aFinder);
			
		
	}

	

}
