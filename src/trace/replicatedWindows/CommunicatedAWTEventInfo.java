package trace.replicatedWindows;
import java.awt.AWTEvent;

import trace.echo.ListEditInfo;
import trace.echo.modular.OperationName;
import util.trace.session.AddressedMessageInfo;
import util.trace.session.ProcessInfo;
//public class CommunicatedListEditInfo extends ListEditInfo {
public class CommunicatedAWTEventInfo extends AWTEventInfo {

	String destinationOrSource;
	String processName;
	
	public CommunicatedAWTEventInfo(String aMessage,
			String aProcessName,
			AWTEvent anAWTEvent, 
			String aDestinationOrSource,
			Object aFinder) {
		super(aMessage, anAWTEvent, aFinder);
//		this.operationName = aName;
//		this.index = anIndex;
//		this.element = anElement;
		processName = aProcessName;
		destinationOrSource = aDestinationOrSource;
	}
	public CommunicatedAWTEventInfo(String aProcessName, AWTEvent anAWTEvent, String aDestinationOrSource) {
		this("",  aProcessName, anAWTEvent, aDestinationOrSource, null);		
	}
	public CommunicatedAWTEventInfo(String aMessage, String aProcessName, String aDestinationOrSource, AWTEventInfo anAWTEventInfo) {
		super(aMessage, anAWTEventInfo);
		processName = aProcessName;
		destinationOrSource = aDestinationOrSource;
	}
	public CommunicatedAWTEventInfo(String aMessage, CommunicatedAWTEventInfo aCommunicatedAWTEventInfo) {
		this(aMessage, aCommunicatedAWTEventInfo.getProcessName(), aCommunicatedAWTEventInfo.getDestinationOrSource(), aCommunicatedAWTEventInfo);
	}

	public static CommunicatedAWTEventInfo toTraceable (String aMessage) {
		AWTEventInfo anAWTinfo = AWTEventInfo.toTraceable(aMessage);
		String aProcessName = ProcessInfo.getProcessName(aMessage);
		String anAddress = AddressedMessageInfo.getAddress(aMessage);		
		return new CommunicatedAWTEventInfo(aMessage, aProcessName, anAddress, anAWTinfo);
	}
	
	
	public String getDestinationOrSource() {
		return destinationOrSource;
	}
	
	public static String toString(String aProcessName, AWTEvent anEvent,  String aDestinationOrSource) {
		return ProcessInfo.toString(aProcessName)  + AWTEventInfo.toLocalInfoToString(anEvent) + 
//				" Address(" + 
				" " + AddressedMessageInfo.ADDRESS + "(" +
				aDestinationOrSource + ")";
	}
	public String alternativeToString() {
		return toString(processName, awtEvent, destinationOrSource);
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public void setDestinationOrSource(String destinationOrSource) {
		this.destinationOrSource = destinationOrSource;
	}
	
}
