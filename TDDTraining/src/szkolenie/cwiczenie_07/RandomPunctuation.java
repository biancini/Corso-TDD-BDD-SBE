package szkolenie.cwiczenie_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class RandomPunctuation {

    private Randomness randomness;

    public RandomPunctuation(Randomness randomness) {
        this.randomness = randomness;
    }

    public String doInsert(String s) {

        List<char[]> chars = Arrays.asList(s.toCharArray());

        int i = 0;
        while (i < chars.size()) {
            if (this.randomness.shouldInsertPunctuation()) {
                char[] c = this.randomness.getRandomPunctuationChar();
                chars.add(i, c);
            }
            i++;
        }

        return String.valueOf(chars);
    }
}
