package trace.causal;

import trace.locking.SlaveLockGrantRequestMade;
import util.session.CommunicatorSelector;
import util.session.SentMessage;
import util.trace.session.ProcessInfo;

public class VectorTimeStampedMessageReceived extends VectorTimeStampedMessageInfo{

//	public VectorTimeStampedMessageBuffered(String aMessage, String aProcess, int aPos, long aLong,
//			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
//		super(aMessage, aProcess, aPos, aLong, aVectorTimeStamp, aFinder);
//		// TODO Auto-generated constructor stub
//	}

	public VectorTimeStampedMessageReceived(String aMessage, 
			long aLong, VectorTimeStampInfo aVectorTimeStamp,
			ProcessInfo aProcessInfo) {
		super(aMessage,  aLong, aVectorTimeStamp, aProcessInfo);
		// TODO Auto-generated constructor stub
	}

	public VectorTimeStampedMessageReceived(String aMessage,
			String aProcessName,  long aLong,
			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
		super(aMessage, aProcessName,  aLong, aVectorTimeStamp, aFinder);
		// TODO Auto-generated constructor stub
	}
	public static VectorTimeStampedMessageReceived newCase(
			String aProcessName,
			SentMessage aSentMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  aSentMessage.getTimeStamp(), aVectorTimeStamp);
		VectorTimeStampedMessageReceived retVal = new VectorTimeStampedMessageReceived(aMessage, aProcessName,  aSentMessage.getTimeStamp(), aVectorTimeStamp, aFinder);
		retVal.announce();
		return retVal;
	}
	public static VectorTimeStampedMessageReceived newCase(
			
			SentMessage aSentMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aSentMessage, aVectorTimeStamp, aFinder);
			
		
	}

}
