package trace.causal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trace.ot.OTTimeStampInfo;
import util.trace.TraceableInfo;
import util.trace.session.ProcessInfo;
/*
 * All traceables are subclass of this, we do not need the object being sent
 */
public class NumberInfo extends ProcessInfo {
	
	Number userToCount;


	public NumberInfo
			(String aMessage, 
			String aProcessName,
			Map<String, Integer> aUserToCount,
			Object aFinder) {
		super(aMessage, aProcessName,  aFinder);
		userToCount = aUserToCount;
	}
	
	public NumberInfo(String aMessage, Map<String, Integer> aUserToCount,
			ProcessInfo aProcessInfo

	// boolean anIsServer,
	// Object aFinder
	) {
		super(aMessage, aProcessInfo);
		userToCount = aUserToCount;

		// userName = aUserName;
		// localCount = aLocalCount;
		// remoteCount = aRemoteCount;
		// isServer = anIsServer;
	}
	public NumberInfo(String aMessage, NumberInfo aVectorTimeStampInfo

			) {
				this(aMessage, aVectorTimeStampInfo.getUserToCount(), aVectorTimeStampInfo);

				// userName = aUserName;
				// localCount = aLocalCount;
				// remoteCount = aRemoteCount;
				// isServer = anIsServer;
			}
	
	public Map<String, Integer> getUserToCount() {
		return userToCount;
	}
	
	public static final String VectorTS = "VectorTS";

//	public boolean isServer() {
//		return isServer;
//	}
	public static String toString(String aProcessName,
			Map<String, Integer> aUserToCount
			) {
		
		//normalize for parsing using getArgs
		return toString(aProcessName) + " " + 	VectorTS + aUserToCount.toString().
				replace("{", "(").
				replace("}", ")");
//				+ "(" +	(anIsServer?"Server": "Client") + ")";
		
	}
	public String alternativeToString() {
		return toString(processName, userToCount);
	}
	
	public static Map<String, Integer> toVectorTS(String aMessage) {
		List<String> args = getArgs(aMessage, VectorTS);
		Map<String, Integer> retVal = new HashMap();
		
		for (String aString:args) {
			String[] aKeyValue = aString.split("=");
			System.out.println("a key value " + aKeyValue);
			String aKey = aKeyValue[0];
			int aValue = Integer.parseInt(aKeyValue[1]);
			retVal.put(aKey, aValue);
			
		}
		return retVal;
	}
	public static NumberInfo toTraceable(String aMessage) {
		Map<String, Integer> userToCount = toVectorTS(aMessage);
		ProcessInfo aProcessInfo = ProcessInfo.toTraceable(aMessage);

		return new NumberInfo(aMessage, userToCount ,
				aProcessInfo);
	}

	public void setUserToCount(Map<String, Integer> userToCount) {
		this.userToCount = userToCount;
	}
	

//	public static void main (String[] args) {
//		Map<String, Integer> userToCount = new HashMap();
//		userToCount.put("Alice", 5);
//		userToCount.put("Bob", 4);
//		System.out.println("my count " + userToCount);
//		
//	}

}
