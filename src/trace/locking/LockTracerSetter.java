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
		Tracer.setKeywordPrintStatus(MasterLockGrantRequestReceived.class, true);	
		Tracer.setKeywordPrintStatus(MasterLockGranted.class, true);
		Tracer.setKeywordPrintStatus(MasterLockReleased.class, true);	
		Tracer.setKeywordPrintStatus(MasterLockReleaseRequestReceived.class, true);	
		Tracer.setKeywordPrintStatus(SlaveLockGrantMadeReceived.class, true);
		Tracer.setKeywordPrintStatus(SlaveLockGrantRequestReceived.class, true);
		Tracer.setKeywordPrintStatus(SlaveLockReleaseRequestSent.class, true);
		Tracer.setKeywordPrintStatus(SlaveLockGrantRequestSent.class, true);
		Tracer.setKeywordPrintStatus(SlaveLockReleaseRequestMade.class, true);
		Tracer.setKeywordPrintStatus(SlaveLockRequestGranted.class, true);
		Tracer.setKeywordPrintStatus(SlaveMyLockGrantMadeReceived.class, true);
		Tracer.setKeywordPrintStatus(SlaveMyLockGrantRequestReceived.class, true);
		Tracer.setKeywordPrintStatus(UserActionVetoed.class, true);
	}

}
