package trace.causal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trace.echo.ListEditInfo;
import util.trace.TraceableInfo;
import util.trace.session.ProcessInfo;

public class VectorTimeStampedMessageInfo extends ProcessInfo {
	VectorTimeStampInfo vectorTimeStamp;
	long messageTimeStamp;
	public static final String REAL_TS = "RealTS";
//	String processName;
	public VectorTimeStampedMessageInfo(String aMessage, String aProcessName,
			long along, VectorTimeStampInfo aVectorTimeStamp,
			Object aFinder) {
		super(aMessage, aProcessName,  aFinder);
//		processName = aProcessName;
		vectorTimeStamp = aVectorTimeStamp;
		messageTimeStamp = along;
	}
	
	public VectorTimeStampedMessageInfo(long along, 
			VectorTimeStampInfo aVectorTimeStamp) {
		this("", "", along, aVectorTimeStamp, null);
	}

	public VectorTimeStampedMessageInfo(String aMessage, long along, 
			VectorTimeStampInfo aVectorTimeStamp, ProcessInfo aProcessInfo) {
//		super(aMessage, "", aProcessInfo);
		super(aMessage, aProcessInfo);

		vectorTimeStamp = aVectorTimeStamp;
		messageTimeStamp = along;
	}

	public VectorTimeStampedMessageInfo(String aMessage, VectorTimeStampedMessageInfo aVectorTimeStampedMessage) {
		this (aMessage, aVectorTimeStampedMessage.getMessageTimeStamp(), aVectorTimeStampedMessage.getVectorTimeStamp(), aVectorTimeStampedMessage);
		
	}
	public static String toLocalInfoToString(String aProcessName, long along,
			VectorTimeStampInfo aVectorTimeStamp) {
		return REAL_TS + "(" + along+  ")" + " "
				+ aVectorTimeStamp.alternativeToString() ;
		
	}
	public static String toString(String aProcessName, long along,
			VectorTimeStampInfo aVectorTimeStamp) {
		return toString(aProcessName) + " " + toLocalInfoToString(aProcessName, along, aVectorTimeStamp);
//				"OTEdit(" + 
//				along.toLocalInfoToString() + " "
//				+ aVectorTimeStamp.alternativeToString() ;
				
//				+ ")";

	}
	
	public static VectorTimeStampedMessageInfo toTraceable(String aMessage) {
//		ProcessInfo aProcessInfo;
//		try {
		ProcessInfo aProcessInfo = ProcessInfo.toTraceable(aMessage);
//		} catch (Exception e) {
//			System.out.println(e);
//			aProcessInfo = null;
//		}
//		long along = long.toTraceable(aMessage);
		long aLong =   Long.parseLong(getArgs(aMessage, REAL_TS).get(0));
		Map<String, Integer> retVal = new HashMap();
		VectorTimeStampInfo aTimeStampInfo = VectorTimeStampInfo.toTraceable(aMessage);
		return new VectorTimeStampedMessageInfo(aMessage, aLong, aTimeStampInfo, aProcessInfo);
		
	}
	

	public String alternativeToString() {
		return toString(processName, messageTimeStamp, vectorTimeStamp);
	}
	public String toLocalInfoToString() {
		return toLocalInfoToString(processName, messageTimeStamp, vectorTimeStamp);
	}


	public VectorTimeStampInfo getVectorTimeStamp() {
		return vectorTimeStamp;
	}

	public long getMessageTimeStamp() {
		return messageTimeStamp;
	}
	
	public String getProcessName() {
		return processName;
	}

}
