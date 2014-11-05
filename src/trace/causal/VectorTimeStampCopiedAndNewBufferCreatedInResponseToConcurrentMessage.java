package trace.causal;

import java.util.Map;

import trace.ot.LocalSiteCountIncremented;
import trace.ot.UserOTTimeStampInfo;
import util.session.CommunicatorSelector;

public class VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage extends VectorTimeStampInfo{

	public VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage(String aMessage, String aProcessName,
			Map<String, Integer> aUserToCount, Object aFinder) {
		super(aMessage, aProcessName, aUserToCount, aFinder);
	}
	public VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage(String aMessage, VectorTimeStampInfo aVectorTimeStampInfo

			) {
				super(aMessage, aVectorTimeStampInfo);

				
			}

	public static VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage toTraceable(String aMessage) {
		VectorTimeStampInfo aTimeStampInfo = VectorTimeStampInfo.toTraceable(aMessage);
		return new VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage(aMessage, 
				aTimeStampInfo);		
	}
	public static VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage newCase(
			String aProcessName,
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aMessage = toString(aProcessName, aUserToCount);
		VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage retVal = new VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage(aMessage, aProcessName, 
				aUserToCount, /*anInServer,*/ aFinder);
		retVal.announce();
		return retVal;
	}
	public static VectorTimeStampCopiedAndNewBufferCreatedInResponseToConcurrentMessage newCase(			
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aProcessName = CommunicatorSelector.getProcessName();
		return newCase(aProcessName, aUserToCount, aFinder);
	}

}
