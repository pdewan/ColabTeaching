package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class SlaveRequestMade extends CommunicatedLockInfo{

	public SlaveRequestMade(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveRequestMade(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveRequestMade toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveRequestMade(aMessage, anInfo);
	}
	public static SlaveRequestMade newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveRequestMade retVal = new SlaveRequestMade(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveRequestMade newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
