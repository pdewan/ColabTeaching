package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class SlaveLockRequestDenied extends CommunicatedLockInfo{

	public SlaveLockRequestDenied(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveLockRequestDenied(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveLockRequestDenied toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveLockRequestDenied(aMessage, anInfo);
	}
	public static SlaveLockRequestDenied newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveLockRequestDenied retVal = new SlaveLockRequestDenied(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveLockRequestDenied newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
