package szkolenie.cwiczenie_07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class ReplaceDiacriticalMarksTest {

    @Test
    public void shouldReplaceDiacriticalMarks() {

        ReplaceDiacriticalMarks replace = new ReplaceDiacriticalMarks();
        String output = replace.doReplace("ĄĆĘŁŃÓŚŹŻąćęłńóśźż");
        String expectedValue = "ACELNOSZZacelnoszz";
        assertEquals(expectedValue, output);
    }
}
