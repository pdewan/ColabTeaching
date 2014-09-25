package trace.replicatedWindows;
import java.awt.AWTEvent;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import trace.echo.modular.OperationName;
import util.trace.Traceable;
import util.trace.TraceableInfo;
public class AWTEventInfo extends TraceableInfo {
	protected AWTEvent awtEvent;
	String name;
	String paramString;
	
	

	public String getName() {
		return name;
	}
	public String getParamString() {
		return paramString;
	}

	public static final String AWT_EVENT = "AWTEvent";
	public static String[] awtEventEqualPropertiesArray = {};
//	public static List<String> listEditEqualPropertiesList = Arrays.asList(listEditEqualPropertiesArray);

	public AWTEventInfo(String aMessage,  AWTEvent anAWTEvent,  Object aFinder) {
		super(aMessage,  aFinder);
		awtEvent = anAWTEvent;
		if (anAWTEvent.getSource() instanceof Component) {
			name = ((Component ) anAWTEvent.getSource()).getName();
		}
		
	}
	protected void setEqualPropertiesList() {
		super.setEqualPropertiesList();
//		String[] listEditEqualPropertiesArray = {"OperationName", "Index", "Element"};

//		consoleEqualPropertiesArray = new String[]{"Output"};
		equalPropertiesList.addAll(Arrays.asList(awtEventEqualPropertiesArray));
//		equalPropertiesList.addAll(listEditEqualPropertiesList);

		
//		equalPropertiesList = Arrays.asList(equalPropertiesArray);

	}
	
	
	public AWTEventInfo(String aName, String aParamString) {
		this("", aName, aParamString, (Traceable) null); 
		
	}
	public AWTEventInfo(String aMessage, 
			String aName, String aParamString, Traceable aTraceable
//			String aProcessName,			
//			Long aTimeStamp,
//			String aThreadName,
//			Object aFinder
			) {
		super(aMessage, aTraceable);
		name = aName;
		paramString = aParamString;
		
	}
	public AWTEventInfo(String aMessage, 
			AWTEventInfo anInfo
//			String aProcessName,			
//			Long aTimeStamp,
//			String aThreadName,
//			Object aFinder
			) {
		this(aMessage, 
				anInfo.name,
				anInfo.paramString,
				null


				 );
	}
	
	public static AWTEventInfo toTraceable (String aMessage) {
		Traceable aTraceable = TraceableInfo.toTraceable(aMessage);
		List<String> anArgs = getArgs(aMessage, AWT_EVENT);
		String aName = getName(anArgs);
		String aParamString = getParamString(anArgs);
		
		return new AWTEventInfo(aMessage, aName, aParamString,  aTraceable);
				
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
	
	
		
	public AWTEvent getAWTEvent() {
		return awtEvent;
	}
	
	public static String toString(AWTEvent anAWTEvent) {
		if (anAWTEvent == null) {
			System.out.println("Null event");
			return "";
		}
		String aName = "";
		if (anAWTEvent.getSource() instanceof Component) {
			aName = ((Component) anAWTEvent.getSource()).getName();
		}
		return toString(System.currentTimeMillis()) +
				" " + AWT_EVENT +  ("(") + 
				aName
				+ "," +
				anAWTEvent.paramString() 

				
			+ ")";
				
	}
	public static String toLocalInfoToString(AWTEvent anAWTEvent) {
		if (anAWTEvent == null) {
			System.out.println("Null event");
			return "";
		}
		String aName = "";
		if (anAWTEvent.getSource() instanceof Component) {
			aName = ((Component) anAWTEvent.getSource()).getName();
		}
	return 
			AWT_EVENT +  ("(") + 
			aName
			+ "," +
			anAWTEvent.paramString() 
		+ ")";
			
}
	public static String getName(List<String> anArgs) {
		return anArgs.get(0);		
	}
	
	public static String getParamString(List<String> anArgs) {
		return anArgs.get(1);
	}
	

//	public String toLocalInfoToString() {
//		return toLocalInfoToString(operationName, index, element, list); 
//	}
	public String alternativeToString() {
//		return "ListEdit(" +  toString(operationName, index, element) + ")";
		return 
//				LIST_EDIT + "(" +
//		"ListEdit(" +  
		
		toString(awtEvent); 
//		")";
	}
	
	public boolean equalsEdit(AWTEventInfo other) {
		return awtEvent.paramString().equals(other.awtEvent.paramString());
	}
	
}
