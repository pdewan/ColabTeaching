package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import trace.sharedWindow.CommunicatedAWTEventInfo;
import util.session.CommunicatorSelector;

public class MasterLockReleased extends CommunicatedLockInfo{

	public MasterLockReleased(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public MasterLockReleased(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static MasterLockReleased toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new MasterLockReleased(aMessage, anInfo);
	}
	public static MasterLockReleased newCase(
			String aProcessName,
			 String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSourceOrDestination);
		MasterLockReleased retVal = new MasterLockReleased(aMessage, aProcessName, aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}
	public static MasterLockReleased newCase(
			 String aSourceOrDestination, Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aSourceOrDestination, aFinder);
			
		
	}

	

}
