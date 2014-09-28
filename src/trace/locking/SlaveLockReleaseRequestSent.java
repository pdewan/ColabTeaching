package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import util.session.CommunicatorSelector;
import util.trace.awt.CommunicatedAWTEventInfo;

public class SlaveLockReleaseRequestSent extends CommunicatedLockInfo{

	public SlaveLockReleaseRequestSent(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveLockReleaseRequestSent(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveLockReleaseRequestSent toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveLockReleaseRequestSent(aMessage, anInfo);
	}
	public static SlaveLockReleaseRequestSent newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveLockReleaseRequestSent retVal = new SlaveLockReleaseRequestSent(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	public static SlaveLockReleaseRequestSent newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
