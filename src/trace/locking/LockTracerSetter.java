package trace.locking;

import trace.echo.modular.EchoTracerSetter;
import util.trace.Tracer;
import util.trace.session.ReceivedMessageDistributedToListeners;
import util.trace.session.SendDataRequest;

public class LockTracerSetter extends EchoTracerSetter{
	
	public static void traceLock() {
		EchoTracerSetter.setTraceParameters();

		setLockPrintStatus();		
	}
	
	public static void setLockPrintStatus() {
		Tracer.setKeywordPrintStatus(MasterLockRequestReceived.class, true);		
;
	}

}
