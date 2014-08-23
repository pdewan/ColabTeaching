package trace.causal;

import java.util.Map;

import trace.ot.LocalSiteCountIncremented;
import trace.ot.UserOTTimeStampInfo;

public class InitialVectorTimeStampCreated extends VectorTimeStampInfo{

	public InitialVectorTimeStampCreated(String aMessage, String aProcessName,
			Map<String, Integer> aUserToCount, Object aFinder) {
		super(aMessage, aProcessName, aUserToCount, aFinder);
	}
	public InitialVectorTimeStampCreated(String aMessage, VectorTimeStampInfo aVectorTimeStampInfo

			) {
				super(aMessage, aVectorTimeStampInfo);

				
			}

	public static InitialVectorTimeStampCreated toTraceable(String aMessage) {
		VectorTimeStampInfo aTimeStampInfo = VectorTimeStampInfo.toTraceable(aMessage);
		return new InitialVectorTimeStampCreated(aMessage, 
				aTimeStampInfo);		
	}
	public static InitialVectorTimeStampCreated newCase(
			String aProcessName,
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aMessage = toString(aProcessName, aUserToCount);
		InitialVectorTimeStampCreated retVal = new InitialVectorTimeStampCreated(aMessage, aProcessName, 
				aUserToCount, /*anInServer,*/ aFinder);
		retVal.announce();
		return retVal;
	}

}
