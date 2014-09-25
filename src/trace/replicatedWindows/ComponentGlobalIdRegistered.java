package trace.replicatedWindows;

import java.awt.AWTEvent;

import trace.echo.modular.OperationName;

public class ComponentGlobalIdRegistered extends CommunicatedAWTEventInfo{

	public ComponentGlobalIdRegistered(String aMessage, String aProcessName, AWTEvent anAWTEvent, String aGlobalId, String aDestinationOrSource, Object aFinder) {
		super(aMessage, aProcessName, anAWTEvent, aGlobalId,  aDestinationOrSource, aFinder);
	}
	public ComponentGlobalIdRegistered(String aMessage, CommunicatedAWTEventInfo anInfo) {
		super(aMessage, anInfo);
	}

	public static ComponentGlobalIdRegistered toTraceable (String aMessage) {
		CommunicatedAWTEventInfo anInfo = CommunicatedAWTEventInfo.toTraceable(aMessage);
		return new ComponentGlobalIdRegistered(aMessage, anInfo);
	}
	public static ComponentGlobalIdRegistered newCase(
			String aProcessName,
			AWTEvent anAWTEvent, String aGlobalId, String aSourceOrDestination, Object aFinder) {
			
		String aMessage = toString(aProcessName, anAWTEvent, aGlobalId, aSourceOrDestination);
		ComponentGlobalIdRegistered retVal = new ComponentGlobalIdRegistered(aMessage, aProcessName, anAWTEvent, aGlobalId,  aSourceOrDestination, aFinder);
		retVal.announce();
		return retVal;
	}

}
