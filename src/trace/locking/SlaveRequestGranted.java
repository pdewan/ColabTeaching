package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class SlaveRequestGranted extends CommunicatedLockInfo{

	public SlaveRequestGranted(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveRequestGranted(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveRequestGranted toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveRequestGranted(aMessage, anInfo);
	}
	public static SlaveRequestGranted newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveRequestGranted retVal = new SlaveRequestGranted(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveRequestGranted newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
