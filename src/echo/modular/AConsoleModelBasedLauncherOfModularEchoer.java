package echo.modular;

import echo.monolithic.AConsoleModelBasedLauncherOfMonolithicEchoer;
import bus.uigen.pipe.AConsoleModelBasedLauncher;
import bus.uigen.pipe.ConsoleModelBasedLauncher;
import bus.uigen.pipe.MainClassLaunchingUtility;

public class AConsoleModelBasedLauncherOfModularEchoer extends AConsoleModelBasedLauncherOfMonolithicEchoer implements ConsoleModelBasedLauncher{
	
//	public Class[] composeMainClasses() {
//		return new Class[] { echoClass() };
//	}
	public Class echoClass() {
		return AnEchoComposerAndLauncher.class;
		// return OTSessionManagerServerStarter.class;

	}

	
//	public  void launch() {	
////		Class[] classes = {
////				SessionManagerServerStarter.class,
////				AliceIM.class,
////				BobIM.class,
////				CathyIM.class				
////		};
//		MainClassLaunchingUtility.createInteractiveLauncher(composeMainClasses());
//	}
	
	public static void main(String args[]) {
		(new AConsoleModelBasedLauncherOfModularEchoer()).launchWithConsoles();
	}

}
