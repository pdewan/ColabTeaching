package trace.replicatedWindows;

import trace.echo.modular.EchoTracerSetter;
import util.trace.Tracer;
import util.trace.session.ReceivedMessageDistributedToListeners;
import util.trace.session.SendDataRequest;

public class ReplicatedWindowTracerSetter extends EchoTracerSetter{
	
	public static void traceReplicatedWindow() {
		EchoTracerSetter.setTraceParameters();

		setReplicatedWindowPrintStatus();		
	}
	
	public static void setReplicatedWindowPrintStatus() {
		Tracer.setKeywordPrintStatus(ComponentTreeRegistered.class, true);		
		Tracer.setKeywordPrintStatus(AWTEventSent.class, true);
//		Tracer.setKeywordPrintStatus(AWTEventReceived.class, true);
		Tracer.setKeywordPrintStatus(ReceivedAWTEventDispatched.class, true);
	}

}
