package szkolenie.cwiczenie_07;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public interface Randomness {

    boolean shouldReplaceUpperLowerCase();

    boolean shouldInsertPunctuation();

    char[] getRandomPunctuationChar();
}
