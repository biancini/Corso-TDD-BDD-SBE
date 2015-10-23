package bnsit.tdd.intro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StringI18nTest {

	@Test
	public void shouldReturnSpecificLanguageVersionByCountryCode() {
		
		StringI18n greeting = new StringI18n("pl", "Dzien dobry przyjacielu");
		greeting.add("en", "Hello friend");
		greeting.add("de", "Hallo Freund");
		
		assertEquals("Hallo Freund", greeting.get("de"));
		assertEquals("Hello friend", greeting.get("en"));
	}
	
	@Test//(expected = StringI18nException.class)
	public void shouldThrowExceptionWhenGettingNonexistingVersion() {
		StringI18n greeting = new StringI18n("pl", "Dzien dobry przyjacielu");

		try {
			greeting.get("en");
			fail();
		} catch (StringI18nException e) {
			assertEquals("expected message", e.getMessage());
		}
	}

	@Test
	public void shouldReturnDefaultVersionWhenNoneSpecified() {
		StringI18n greeting = new StringI18n("pl", "Dzien dobry przyjacielu");

		String result = greeting.get();	
		
		assertEquals("Dzien dobry przyjacielu", result);
	}

}
