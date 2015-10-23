package szkolenie.cwiczenie_07;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class StubRandomness implements Randomness {

    int counter = 0;

    @Override
    public boolean shouldReplaceUpperLowerCase() {
        return (counter++ % 2 == 1);
    }

    @Override
    public boolean shouldInsertPunctuation() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public char[] getRandomPunctuationChar() {
        return new char[0];  //To change body of implemented methods use File | Settings | File Templates.
    }

}
