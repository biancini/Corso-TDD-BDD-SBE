package szkolenie.cwiczenie_07;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class RandomUpperLowerCase {

    private Randomness randomness;

    public RandomUpperLowerCase(Randomness randomness) {
        this.randomness = randomness;
    }

    public String doReplace(String input) {

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isLetter(c) && this.randomness.shouldReplaceUpperLowerCase()) {
                if (Character.isLowerCase(c)) {
                    chars[i] = Character.toUpperCase(c);
                } else {
                    chars[i] = Character.toLowerCase(c);
                }
            }
        }

        return String.valueOf(chars);
    }
}
