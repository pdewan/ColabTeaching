package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import util.session.CommunicatorSelector;
import util.trace.awt.CommunicatedAWTEventInfo;

public class SlaveMyLockGrantMadeReceived extends CommunicatedLockInfo{

	public SlaveMyLockGrantMadeReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveMyLockGrantMadeReceived(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveMyLockGrantMadeReceived toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveMyLockGrantMadeReceived(aMessage, anInfo);
	}
	public static SlaveMyLockGrantMadeReceived newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveMyLockGrantMadeReceived retVal = new SlaveMyLockGrantMadeReceived(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	
	/**
	 * @param aFinder
	 * @return
	 *  Fired if the lock was granted to me
	 */
	public static SlaveMyLockGrantMadeReceived newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
