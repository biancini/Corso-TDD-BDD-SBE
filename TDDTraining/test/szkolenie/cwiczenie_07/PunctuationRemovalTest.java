package szkolenie.cwiczenie_07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class PunctuationRemovalTest {

    @Test
    public void shouldRemovePunctuation() {

        PunctuationRemoval punctuationRemoval = new PunctuationRemoval();
        String output = punctuationRemoval.doRemove("this;sentence,contains.punctuation!even?questionmark:and colon");
        assertEquals("thissentencecontainspunctuationevenquestionmarkand colon", output);
    }
}
