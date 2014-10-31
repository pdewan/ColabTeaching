package trace.causal;

import java.util.Map;

import trace.ot.LocalSiteCountIncremented;
import trace.ot.UserOTTimeStampInfo;
import util.session.CommunicatorSelector;

public class InsertedAtIndex extends VectorTimeStampInfo{

	public InsertedAtIndex(String aMessage, String aProcessName,
			Map<String, Integer> aUserToCount, Object aFinder) {
		super(aMessage, aProcessName, aUserToCount, aFinder);
	}
	public InsertedAtIndex(String aMessage, VectorTimeStampInfo aVectorTimeStampInfo

			) {
				super(aMessage, aVectorTimeStampInfo);

				
			}

	public static InsertedAtIndex toTraceable(String aMessage) {
		VectorTimeStampInfo aTimeStampInfo = VectorTimeStampInfo.toTraceable(aMessage);
		return new InsertedAtIndex(aMessage, 
				aTimeStampInfo);		
	}
	public static InsertedAtIndex newCase(
			String aProcessName,
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aMessage = toString(aProcessName, aUserToCount);
		InsertedAtIndex retVal = new InsertedAtIndex(aMessage, aProcessName, 
				aUserToCount, /*anInServer,*/ aFinder);
		retVal.announce();
		return retVal;
	}
	public static InsertedAtIndex newCase(			
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aProcessName = CommunicatorSelector.getProcessName();
		return newCase(aProcessName, aUserToCount, aFinder);
	}

}
