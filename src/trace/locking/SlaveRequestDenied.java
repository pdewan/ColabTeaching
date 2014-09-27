package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class SlaveRequestDenied extends CommunicatedLockInfo{

	public SlaveRequestDenied(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveRequestDenied(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveRequestDenied toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveRequestDenied(aMessage, anInfo);
	}
	public static SlaveRequestDenied newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveRequestDenied retVal = new SlaveRequestDenied(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveRequestDenied newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
