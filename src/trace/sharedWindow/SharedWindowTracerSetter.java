package trace.sharedWindow;

import trace.echo.modular.EchoTracerSetter;
import util.trace.Tracer;
import util.trace.session.ReceivedMessageDistributedToListeners;
import util.trace.session.SendDataRequest;

public class SharedWindowTracerSetter extends EchoTracerSetter{
	
	public static void traceReplicatedWindow() {
		EchoTracerSetter.setTraceParameters();

		setSharedWindowPrintStatus();		
	}
	
	public static void setSharedWindowPrintStatus() {
		Tracer.setKeywordPrintStatus(ComponentTreeRegistered.class, true);		
		Tracer.setKeywordPrintStatus(AWTEventSent.class, true);
//		Tracer.setKeywordPrintStatus(AWTEventReceived.class, true);
		Tracer.setKeywordPrintStatus(ReceivedAWTEventDispatched.class, true);
	}

}
