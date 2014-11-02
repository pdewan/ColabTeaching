package trace.causal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trace.echo.ListEditInfo;
import util.trace.TraceableInfo;
import util.trace.session.ProcessInfo;

public class OrderedVectorTimeStampedMessageInfo extends VectorTimeStampedMessageInfo {
//	VectorTimeStampedMessageInfo vectorTimeStampedMessage;
	int pos;
	public static final String POS = "Pos";
//	String processName;
	public OrderedVectorTimeStampedMessageInfo(String aMessage, String aProcessName,
			int aPos, long aLong, VectorTimeStampInfo aVectorTimeStamp,
			Object aFinder) {
		super(aMessage, aProcessName, aLong, aVectorTimeStamp, aFinder);
//		processName = aProcessName;
		pos = aPos;
	}
	
	public OrderedVectorTimeStampedMessageInfo(int aPos, long aLong,
			VectorTimeStampInfo aVectorTimeStamp) {
		this("", "", aPos, aLong,  aVectorTimeStamp, null);
	}

	public OrderedVectorTimeStampedMessageInfo(String aMessage, int aPos, long aLong,
			VectorTimeStampInfo aVectorTimeStamp, ProcessInfo aProcessInfo) {
//		super(aMessage, "", aProcessInfo);
		super(aMessage, aLong, aVectorTimeStamp, aProcessInfo);

		pos = aPos;
	}

//	public OrderedVectorTimeStampedMessageInfo(String aMessage, OrderedVectorTimeStampedMessageInfo anOrderedInfo) {
//		this (aMessage, anOrderedInfo.getListEdit(), anOrderedInfo.getUserOTTimeStamp(), anOrderedInfo);
//		
//	}
	public static String toLocalInfoToString(String aProcessName, int aPos, long aTS,
			VectorTimeStampInfo aVectorTimeStampedMessage) {
		return POS + "(" + aPos+  ")" + " " + toLocalInfoToString (aProcessName, aTS, aVectorTimeStampedMessage);
//				+ aVectorTimeStampedMessage.alternativeToString() ;
		
	}
	public static String toString(String aProcessName, int aPos,
			long aLong, VectorTimeStampInfo aVectorTimeStamp) {
		return toString(aProcessName) + " " + toLocalInfoToString(aProcessName, aPos, aLong, aVectorTimeStamp);
//				"OTEdit(" + 
//				aPos.toLocalInfoToString() + " "
//				+ aVectorTimeStamp.alternativeToString() ;
				
//				+ ")";

	}
	
	public static OrderedVectorTimeStampedMessageInfo toTraceable(String aMessage) {
//		ProcessInfo aProcessInfo;
//		try {
		ProcessInfo aProcessInfo = ProcessInfo.toTraceable(aMessage);
//		} catch (Exception e) {
//			System.out.println(e);
//			aProcessInfo = null;
//		}
//		long aPos = long.toTraceable(aMessage);
		int aPos =   Integer.parseInt(getArgs(aMessage, POS).get(0));
		VectorTimeStampedMessageInfo aMessageInfo = VectorTimeStampedMessageInfo.toTraceable(aMessage);
		return new OrderedVectorTimeStampedMessageInfo(aMessage, aPos, aMessageInfo.getMessageTimeStamp(), aMessageInfo.getVectorTimeStamp(),
				aProcessInfo);
		
	}
	

	public String alternativeToString() {
		return toString(processName, pos, messageTimeStamp, vectorTimeStamp);
	}
	public String toLocalInfoToString() {
		return toLocalInfoToString(processName, pos, messageTimeStamp, vectorTimeStamp);
	}


	

	public long getPosition() {
		return pos;
	}
	


}
