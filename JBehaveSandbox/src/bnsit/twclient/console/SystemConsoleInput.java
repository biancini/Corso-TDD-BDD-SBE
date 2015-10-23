package bnsit.twclient.console;

import java.util.Scanner;

public class SystemConsoleInput implements ConsoleInput {

	private Scanner scanner = new Scanner(System.in);
	
	@Override
	public String nextLine() {
		return scanner.nextLine();
	}

}
