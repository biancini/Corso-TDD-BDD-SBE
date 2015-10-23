package bnsit.twclient.console;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

public class FakeConsoleOutput implements ConsoleOutput {

	private List<String> printedText = new ArrayList<String>();
	
	@Override
	public void println(String text) {
		printedText.add(text);
	}

	public void assertLastLineEquals(String expected) {
		assertNotNull(expected);
		
		assertEquals(expected, printedText.get(printedText.size() -1));
	}

	public void assertHasMoreEntriesThan(int count) {
		assertTrue(printedText.size() > count);
	}

}
