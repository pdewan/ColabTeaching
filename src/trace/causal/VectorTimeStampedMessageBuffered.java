package trace.causal;

import trace.locking.SlaveLockGrantRequestMade;
import util.session.CommunicatorSelector;
import util.session.ReceivedMessage;
import util.trace.session.ProcessInfo;

public class VectorTimeStampedMessageBuffered extends OrderedVectorTimeStampedMessageInfo{

//	public VectorTimeStampedMessageBuffered(String aMessage, String aProcess, int aPos, long aLong,
//			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
//		super(aMessage, aProcess, aPos, aLong, aVectorTimeStamp, aFinder);
//		// TODO Auto-generated constructor stub
//	}

	public VectorTimeStampedMessageBuffered(String aMessage, int aPos,
			long aLong, VectorTimeStampInfo aVectorTimeStamp,
			ProcessInfo aProcessInfo) {
		super(aMessage, aPos, aLong, aVectorTimeStamp, aProcessInfo);
		// TODO Auto-generated constructor stub
	}

	public VectorTimeStampedMessageBuffered(String aMessage,
			String aProcessName, int aPos, long aLong,
			VectorTimeStampInfo aVectorTimeStamp, Object aFinder) {
		super(aMessage, aProcessName, aPos, aLong, aVectorTimeStamp, aFinder);
		// TODO Auto-generated constructor stub
	}
	public static VectorTimeStampedMessageBuffered newCase(
			String aProcessName,
			int aPos,
			ReceivedMessage aReceivedMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
			
		String aMessage = toString(aProcessName, aPos, aReceivedMessage.getTimeStamp(), aVectorTimeStamp);
		VectorTimeStampedMessageBuffered retVal = new VectorTimeStampedMessageBuffered(aMessage, aProcessName, aPos, aReceivedMessage.getTimeStamp(), aVectorTimeStamp, aFinder);
		retVal.announce();
		return retVal;
	}
	public static VectorTimeStampedMessageBuffered newCase(
			int aPos,
			ReceivedMessage aReceivedMessage,
			VectorTimeStampInfo aVectorTimeStamp,
			  Object aFinder) {
		
		return newCase(CommunicatorSelector.getProcessName(), aPos, aReceivedMessage, aVectorTimeStamp, aFinder);
			
		
	}

}
