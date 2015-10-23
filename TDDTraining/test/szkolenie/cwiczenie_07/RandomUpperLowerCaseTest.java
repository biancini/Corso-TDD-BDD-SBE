package szkolenie.cwiczenie_07;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class RandomUpperLowerCaseTest {

    @Test
    public void shouldRandomlyReplaceCase() {

        Randomness randomness = new StubRandomness();
        RandomUpperLowerCase randomUpperLowerCase = new RandomUpperLowerCase(randomness);
        String output = randomUpperLowerCase.doReplace("UPPERCASE_lowercase");
        String expected = "UpPeRcAsE_LoWeRcAsE";
        assertEquals(expected, output);
    }
}
