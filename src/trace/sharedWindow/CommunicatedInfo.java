package trace.sharedWindow;
import java.awt.AWTEvent;

import trace.echo.ListEditInfo;
import trace.echo.modular.OperationName;
import trace.sharedWindow.old.AWTEventInfo;
import util.trace.TraceableInfo;
import util.trace.session.AddressedMessageInfo;
import util.trace.session.ProcessInfo;
//public class CommunicatedListEditInfo extends ListEditInfo {
public class CommunicatedInfo extends TraceableInfo {

	String destinationOrSource;
	String processName;
	
	public CommunicatedInfo(String aMessage,
			String aProcessName,
			String aDestinationOrSource,
			Object aFinder) {
		super(aMessage,  aFinder);
//		this.operationName = aName;
//		this.index = anIndex;
//		this.element = anElement;
		processName = aProcessName;
		destinationOrSource = aDestinationOrSource;
	}
	public CommunicatedInfo(String aProcessName,  String aDestinationOrSource) {
		this("",  aProcessName,  aDestinationOrSource, null);		
	}
	public CommunicatedInfo(String aMessage, String aProcessName, String aDestinationOrSource) {
		super(aMessage);
		processName = aProcessName;
		destinationOrSource = aDestinationOrSource;
	}
	public CommunicatedInfo(String aMessage, CommunicatedInfo aCommunicatedAWTEventInfo) {
		this(aMessage, aCommunicatedAWTEventInfo.getProcessName(), aCommunicatedAWTEventInfo.getDestinationOrSource(), aCommunicatedAWTEventInfo);
	}

	public static CommunicatedInfo toTraceable (String aMessage) {
		AWTEventInfo anAWTinfo = AWTEventInfo.toTraceable(aMessage);
		String aProcessName = ProcessInfo.getProcessName(aMessage);
		String anAddress = AddressedMessageInfo.getAddress(aMessage);		
		return new CommunicatedInfo(aMessage, aProcessName, anAddress, anAWTinfo);
	}
	
	
	public String getDestinationOrSource() {
		return destinationOrSource;
	}
	
	public static String toString(String aProcessName,  String aDestinationOrSource) {
		return ProcessInfo.toString(aProcessName)  + 
//				" Address(" + 
				" " + AddressedMessageInfo.ADDRESS + "(" +
				aDestinationOrSource + ")";
	}
	public String alternativeToString() {
		return toString(processName,  destinationOrSource);
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
