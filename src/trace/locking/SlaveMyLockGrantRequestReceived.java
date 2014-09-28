package trace.locking;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;
import util.session.CommunicatorSelector;
import util.trace.awt.CommunicatedAWTEventInfo;

public class SlaveMyLockGrantRequestReceived extends CommunicatedLockInfo{

	public SlaveMyLockGrantRequestReceived(String aMessage, String aProcessName,   String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName,  aDestinationOrSource, aFinder);
	}
	public SlaveMyLockGrantRequestReceived(String aMessage, CommunicatedLockInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static SlaveMyLockGrantRequestReceived toTraceable (String aMessage) {
		CommunicatedLockInfo anInfo = CommunicatedLockInfo.toTraceable(aMessage);
		return new SlaveMyLockGrantRequestReceived(aMessage, anInfo);
	}
	public static SlaveMyLockGrantRequestReceived newCase(
			String aProcessName,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  null);
		SlaveMyLockGrantRequestReceived retVal = new SlaveMyLockGrantRequestReceived(aMessage, aProcessName, null, aFinder);
		retVal.announce();
		return retVal;
	}
	/**
	 * @param aFinder
	 * @return
	 *  Fired if the  request is for a lock I hold
	 */
	public static SlaveMyLockGrantRequestReceived newCase(
			 Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aFinder);
			
		
	}

	

}
