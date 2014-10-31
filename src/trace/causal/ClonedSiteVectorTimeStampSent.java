package trace.causal;

import java.util.Map;

import trace.ot.LocalSiteCountIncremented;
import trace.ot.UserOTTimeStampInfo;
import util.session.CommunicatorSelector;

public class ClonedSiteVectorTimeStampSent extends VectorTimeStampInfo{

	public ClonedSiteVectorTimeStampSent(String aMessage, String aProcessName,
			Map<String, Integer> aUserToCount, Object aFinder) {
		super(aMessage, aProcessName, aUserToCount, aFinder);
	}
	public ClonedSiteVectorTimeStampSent(String aMessage, VectorTimeStampInfo aVectorTimeStampInfo

			) {
				super(aMessage, aVectorTimeStampInfo);

				
			}

	public static ClonedSiteVectorTimeStampSent toTraceable(String aMessage) {
		VectorTimeStampInfo aTimeStampInfo = VectorTimeStampInfo.toTraceable(aMessage);
		return new ClonedSiteVectorTimeStampSent(aMessage, 
				aTimeStampInfo);		
	}
	public static ClonedSiteVectorTimeStampSent newCase(
			String aProcessName,
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aMessage = toString(aProcessName, aUserToCount);
		ClonedSiteVectorTimeStampSent retVal = new ClonedSiteVectorTimeStampSent(aMessage, aProcessName, 
				aUserToCount, /*anInServer,*/ aFinder);
		retVal.announce();
		return retVal;
	}
	public static ClonedSiteVectorTimeStampSent newCase(			
			Map<String, Integer> aUserToCount, 
			Object aFinder) {
		String aProcessName = CommunicatorSelector.getProcessName();
		return newCase(aProcessName, aUserToCount, aFinder);
	}

}
