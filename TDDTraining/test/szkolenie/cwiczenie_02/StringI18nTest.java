package szkolenie.cwiczenie_02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class StringI18nTest {

    @Test
    public void shouldReturnSpecificLanguageVersionByCountryCode() {

        StringI18n greeting = new StringI18n("pl", "Dzień dobry");
        greeting.add("en", "Hello friend");
        greeting.add("de", "Hallo Freund");

        assertEquals("Hallo Freund", greeting.get("de"));
        assertEquals("Hello friend", greeting.get("en"));
    }


    @Test(expected = StringI18nException.class)
    public void shouldThrowExceptionWhenVersionDoesNotExist() {

        StringI18n greeting = new StringI18n("pl", "Dzień dobry");
        greeting.get("de");

        //expected exception
    }

    @Test
    public void shouldReturnDefaultLanguageVersion() {

        StringI18n greeting = new StringI18n("pl", "Dzień dobry");

        String defaultVersion = greeting.get();

        assertEquals("Dzień dobry", defaultVersion);
    }

}
