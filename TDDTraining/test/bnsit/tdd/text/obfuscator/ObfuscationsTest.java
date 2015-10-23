package bnsit.tdd.text.obfuscator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class ObfuscationsTest {

	private Obfuscations obfuscations;

	@Before
	public void setUp() {
		obfuscations = new Obfuscations();
	}
	
	@Test
	public void shouldRemoveSpaces() {
		String obfuscated = obfuscations.removeSpace("There is a lady who's sure");
		
		assertEquals("Thereisaladywho'ssure", obfuscated);
	}
	
	@Test
	public void shouldReplaceLowerAndUppercaseRandomly() {
		Randomness randomnessMock = mock(Randomness.class);
		obfuscations = new Obfuscations(randomnessMock);
		when(randomnessMock.shouldBeDoneWith(anyDouble()))
			.thenReturn(false, false, true, true, false);
		
		String obfuscated 
			= obfuscations.replaceLowerAndUppercaseRandomly("There is");
		
		assertEquals("ThERe is", obfuscated);
	} 
	
	@Test
	public void shouldInsertPunctutationRandomly() {
		Randomness randomnessMock = mock(Randomness.class);
		obfuscations = new Obfuscations(randomnessMock);
		when(randomnessMock.shouldBeDoneWith(anyDouble()))
			.thenReturn(true, false, false, false, true);		
		
		String obfuscated 
			= obfuscations.insertPunctuationRandomly("There is a lady who's sure");
		
		assertEquals("There!is a lady who's!sure", obfuscated);
	}

}
