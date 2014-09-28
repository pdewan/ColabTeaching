package trace.locking;

import trace.access.InputRightRequested;
import trace.control.UserActionDenied;
import trace.echo.modular.EchoTracerSetter;
import util.trace.Tracer;

public class LockTracerSetter extends EchoTracerSetter{
	
	public static void traceLock() {
		EchoTracerSetter.setTraceParameters();

		setLockPrintStatus();		
	}
	
	public static void setLockPrintStatus() {
		Tracer.setKeywordPrintStatus(InputRightRequested.class, true);	
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
		Tracer.setKeywordPrintStatus(UserActionDenied.class, true);
	}

}
