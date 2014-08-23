package im.timestamp;

import util.session.Communicator;

public class AnAliceTimeStampedIM {
	public static final String SESSION_NAME = "FrostySession";
	public static final String USER_NAME = "Alice";
	public static final String SESSION_SERVER_HOST = "localhost";
	public static void main (String[] args) {
		String[] launcherArgs = {SESSION_SERVER_HOST, SESSION_NAME, USER_NAME, Communicator.DIRECT};
		(new ATimeStampingIMComposerAndLauncher()).composeAndLaunch(launcherArgs);
	}
	
}
