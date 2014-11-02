package trace.causal;

import trace.locking.SlaveLockGrantRequestMade;
import util.session.CommunicatorSelector;
import util.session.SentMessage;
import util.trace.session.ProcessInfo;

public class VectorTimeStampedMessageSent extends VectorTimeStampedMessageInfo{

//	public VectorTimeStampedMessageBuffered(String aMessage, String aProcess, int aPos, long aLong,
//			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
//		super(aMessage, aProcess, aPos, aLong, aVectorTimeStamp, aFinder);
//		// TODO Auto-generated constructor stub
//	}

	public VectorTimeStampedMessageSent(String aMessage, 
			long aLong, VectorTimeStampInfo aVectorTimeStamp,
			ProcessInfo aProcessInfo) {
		super(aMessage,  aLong, aVectorTimeStamp, aProcessInfo);
		// TODO Auto-generated constructor stub
	}

	public VectorTimeStampedMessageSent(String aMessage,
			String aProcessName,  long aLong,
			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
		super(aMessage, aProcessName,  aLong, aVectorTimeStamp, aFinder);
		// TODO Auto-generated constructor stub
	}
	public static VectorTimeStampedMessageSent newCase(
			String aProcessName,
			SentMessage aSentMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSentMessage.getTimeStamp(), aVectorTimeStamp);
		VectorTimeStampedMessageSent retVal = new VectorTimeStampedMessageSent(aMessage, aProcessName,  aSentMessage.getTimeStamp(), aVectorTimeStamp, aFinder);
		retVal.announce();
		return retVal;
	}
	public static VectorTimeStampedMessageSent newCase(
			
			SentMessage aSentMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aSentMessage, aVectorTimeStamp, aFinder);
			
		
	}

}
