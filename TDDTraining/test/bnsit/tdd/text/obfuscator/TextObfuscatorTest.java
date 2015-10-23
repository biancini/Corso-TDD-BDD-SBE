package bnsit.tdd.text.obfuscator;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.InOrder;

public class TextObfuscatorTest {

	@Test
	public void shouldObfuscateText() {
		Obfuscations mockObfuscations = mock(Obfuscations.class);
		TextObfuscator obfuscator = new TextObfuscator(mockObfuscations);
		
		obfuscator.obfuscate("There is a lady who's sure all that glitters...");

		InOrder inOrder = inOrder(mockObfuscations);
		inOrder.verify(mockObfuscations).insertPunctuationRandomly(anyString());
		inOrder.verify(mockObfuscations).replaceLowerAndUppercaseRandomly(anyString());
		inOrder.verify(mockObfuscations).removeSpace(anyString());
	}

}
