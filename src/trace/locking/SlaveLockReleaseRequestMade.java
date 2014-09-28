package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import util.session.CommunicatorSelector;
import util.trace.awt.CommunicatedAWTEventInfo;

public class SlaveLockReleaseRequestMade extends CommunicatedLockInfo{

	public SlaveLockReleaseRequestMade(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveLockReleaseRequestMade(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveLockReleaseRequestMade toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveLockReleaseRequestMade(aMessage, anInfo);
	}
	public static SlaveLockReleaseRequestMade newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveLockReleaseRequestMade retVal = new SlaveLockReleaseRequestMade(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveLockReleaseRequestMade newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
