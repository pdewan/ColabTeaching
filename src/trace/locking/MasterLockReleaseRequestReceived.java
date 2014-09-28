package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import util.session.CommunicatorSelector;
import util.trace.awt.CommunicatedAWTEventInfo;

public class MasterLockReleaseRequestReceived extends CommunicatedLockInfo{

	public MasterLockReleaseRequestReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public MasterLockReleaseRequestReceived(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static MasterLockReleaseRequestReceived toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new MasterLockReleaseRequestReceived(aMessage, anInfo);
	}
	public static MasterLockReleaseRequestReceived newCase(
			String aProcessName,
			 String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSourceOrDestination);
		MasterLockReleaseRequestReceived retVal = new MasterLockReleaseRequestReceived(aMessage, aProcessName, aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}
	public static MasterLockReleaseRequestReceived newCase(
			 String aSourceOrDestination, Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aSourceOrDestination, aFinder);
			
		
	}

	

}
