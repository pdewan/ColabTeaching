package echo.monolithic;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static echo.monolithic.EchoUtilities.*;

import trace.echo.modular.ListEditInput;
import trace.echo.modular.ListEditObserved;
import trace.echo.modular.OperationName;
import util.annotations.Tags;
import util.tags.ApplicationTags;
import util.tags.InteractiveTags;
@Tags({ApplicationTags.ECHOER})
public class MonolithicEchoer  {	
	protected static List<String> history = new ArrayList();
	public static void main(String[] anArgs) {
		for (;;) {
			System.out.println(PROMPT);
			Scanner scanner = new Scanner(System.in);
			String nextInput = scanner.nextLine();
			if (nextInput.equals(QUIT)) {
				processQuit();
				break;
			} else if (nextInput.equals(HISTORY))
				printHistory();
			else
			    processInput(nextInput);
		}
	}
	protected static void displayOutput(String newValue) {
//		System.out.println(EchoUtilities.echo(newValue));
		System.out.println(newValue);

	}
	protected  static void addToHistory(String newValue) {
		history.add(history.size(), newValue);
	}
	protected static void processInput(String anInput) {
		String aFeedback = EchoUtilities.echo(anInput);
		addToHistory(aFeedback);
		displayOutput(aFeedback);

	}
	protected static void processQuit() {
		System.out.println("Quitting application");
	}
	public static String toString(List aHistory) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int index = 0; index < aHistory.size(); index++) {
			stringBuilder.append(aHistory.get(index));			
			stringBuilder.append((index == aHistory.size() - 1)? "\n":", ");
		}		
		return stringBuilder.toString();
	}
	public static  void printHistory() {
		System.out.println(toString(history));
	}
	

}
