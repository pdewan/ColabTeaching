package trace.causal;

import trace.locking.SlaveLockGrantRequestMade;
import util.session.CommunicatorSelector;
import util.session.ReceivedMessage;
import util.trace.session.ProcessInfo;

public class VectorTimeStampedMessageRemovedFromBuffer extends VectorTimeStampedMessageInfo{

//	public VectorTimeStampedMessageBuffered(String aMessage, String aProcess, int aPos, long aLong,
//			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
//		super(aMessage, aProcess, aPos, aLong, aVectorTimeStamp, aFinder);
//		// TODO Auto-generated constructor stub
//	}

	public VectorTimeStampedMessageRemovedFromBuffer(String aMessage, 
			long aLong, VectorTimeStampInfo aVectorTimeStamp,
			ProcessInfo aProcessInfo) {
		super(aMessage,  aLong, aVectorTimeStamp, aProcessInfo);
		// TODO Auto-generated constructor stub
	}

	public VectorTimeStampedMessageRemovedFromBuffer(String aMessage,
			String aProcessName,  long aLong,
			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
		super(aMessage, aProcessName,  aLong, aVectorTimeStamp, aFinder);
		// TODO Auto-generated constructor stub
	}
	public static VectorTimeStampedMessageRemovedFromBuffer newCase(
			String aProcessName,
			ReceivedMessage aReceivedMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName,  aReceivedMessage.getTimeStamp(), aVectorTimeStamp);
		VectorTimeStampedMessageRemovedFromBuffer retVal = new VectorTimeStampedMessageRemovedFromBuffer(aMessage, aProcessName,  aReceivedMessage.getTimeStamp(), aVectorTimeStamp, aFinder);
		retVal.announce();
		return retVal;
	}
	public static VectorTimeStampedMessageRemovedFromBuffer newCase(
			
			ReceivedMessage aReceivedMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(),  aReceivedMessage, aVectorTimeStamp, aFinder);
			
		
	}

}
