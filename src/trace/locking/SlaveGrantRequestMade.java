package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class SlaveGrantRequestMade extends CommunicatedLockInfo{

	public SlaveGrantRequestMade(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveGrantRequestMade(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveGrantRequestMade toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveGrantRequestMade(aMessage, anInfo);
	}
	public static SlaveGrantRequestMade newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveGrantRequestMade retVal = new SlaveGrantRequestMade(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveGrantRequestMade newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
