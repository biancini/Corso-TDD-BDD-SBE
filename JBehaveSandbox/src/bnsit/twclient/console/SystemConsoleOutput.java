package bnsit.twclient.console;

public class SystemConsoleOutput implements ConsoleOutput {

	@Override
	public void println(String text) {
		System.out.println(text);
	}

}
