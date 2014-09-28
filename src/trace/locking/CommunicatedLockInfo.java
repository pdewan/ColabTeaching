package trace.locking;
import java.awt.AWTEvent;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import trace.echo.modular.OperationName;
import util.trace.Traceable;
import util.trace.TraceableInfo;
import util.trace.session.AddressedMessageInfo;
import util.trace.session.CommunicatedInfo;
import util.trace.session.ProcessInfo;
public class CommunicatedLockInfo extends CommunicatedInfo {


	public CommunicatedLockInfo(String aMessage,
			String aProcessName,
			String aDestinationOrSource,
			Object aFinder) {
		super(aMessage, aProcessName, aDestinationOrSource, aFinder);
		
		
	}
	
	
	
	
	public CommunicatedLockInfo() {
		this("",   null); 
		
	}
	public CommunicatedLockInfo(String aMessage, 
			
			CommunicatedInfo aTraceable
//			String aProcessName,			
//			Long aTimeStamp,
//			String aThreadName,
//			Object aFinder
			) {
		super(aMessage, aTraceable);
		
		
	}
	
	
	public static CommunicatedLockInfo toTraceable (String aMessage) {
		CommunicatedInfo aTraceable = CommunicatedInfo.toTraceable(aMessage);
		
		
		return new CommunicatedLockInfo(aMessage, aTraceable);
				
	}
	
//	public static String getListEdit(String aMessage) {
//		return getArgOfCompositeDescriptor(aMessage, LIST_EDIT);
//	}
//	
//	public static OperationName getOperationName(String aMessage) {
//		String aListEdit = getListEdit(aMessage);
//		aListEdit = aListEdit.trim();
//		int aNameEndIndex = aListEdit.indexOf("(");
//		String aName = aListEdit.substring(0, aNameEndIndex);
//		return OperationName.fromString(aName);
//	}
//	
	
	
		
	
	
	
	
//	public String toLocalInfoToString() {
//		return toLocalInfoToString(operationName, index, element, list); 
//	}
	
}
