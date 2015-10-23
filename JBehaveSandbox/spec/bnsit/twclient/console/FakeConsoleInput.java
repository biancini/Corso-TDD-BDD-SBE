package bnsit.twclient.console;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FakeConsoleInput implements ConsoleInput {

	List<String> textToEnter = new ArrayList<String>();
	private Iterator<String> textToEnterIterator;
	
	public void enterText(String text) {
		textToEnter.add(text);
		textToEnterIterator = textToEnter.iterator();
	}
	
	public String nextLine() {
		return textToEnterIterator.next();
	}
}
