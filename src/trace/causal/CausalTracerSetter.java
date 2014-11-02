package trace.causal;

import trace.access.InputRightRequested;
import trace.control.UserActionDenied;
import trace.echo.modular.EchoTracerSetter;
import util.trace.Tracer;

public class CausalTracerSetter extends EchoTracerSetter{
	
	public static void traceLock() {
		EchoTracerSetter.setTraceParameters();

		setLockPrintStatus();		
	}
	
	public static void setLockPrintStatus() {
		Tracer.setKeywordPrintStatus(LocalCountIncrementedInSiteVectorTimeStamp.class, true);
		Tracer.setKeywordPrintStatus(UserAddedToVectorTimeStamp.class, true);
		Tracer.setKeywordPrintStatus(VectorTimeStampCreated.class, true);
		Tracer.setKeywordPrintStatus(VectorTimeStampedMessageBuffered.class, true);
		Tracer.setKeywordPrintStatus(VectorTimeStampedMessageReceived.class, true);	
		Tracer.setKeywordPrintStatus(VectorTimeStampedMessageRemovedFromBuffer.class, true);	
		Tracer.setKeywordPrintStatus(VectorTimeStampedMessageSent.class, true);		
	}

}
