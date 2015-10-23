package szkolenie.cwiczenie_07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class RandomPunctuationTest {

    @Test
    public void shouldInsertRandomPunctuation() {

        Randomness randomness = new StubRandomness();
        RandomPunctuation randomPunctuation = new RandomPunctuation(randomness);
        String output = randomPunctuation.doInsert("thistexthasnopunctuation ");
        assertEquals("this,text.hasn!opun?ctua:ion ;", output);
    }
}
