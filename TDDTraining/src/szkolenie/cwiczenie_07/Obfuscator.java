package szkolenie.cwiczenie_07;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class Obfuscator {

    private final DeleteSpaces deleteSpaces;
    private final PunctuationRemoval punctuationRemoval;
    private final RandomPunctuation randomPunctuation;
    private final ReplaceDiacriticalMarks replaceDiacriticalMarks;
    private final RandomUpperLowerCase randomUpperLowerCase;

    public Obfuscator(DeleteSpaces deleteSpaces, PunctuationRemoval punctuationRemoval, RandomPunctuation randomPunctuation, ReplaceDiacriticalMarks replaceDiacriticalMarks, RandomUpperLowerCase randomUpperLowerCase) {
        this.deleteSpaces = deleteSpaces;
        this.punctuationRemoval = punctuationRemoval;
        this.randomPunctuation = randomPunctuation;
        this.replaceDiacriticalMarks = replaceDiacriticalMarks;
        this.randomUpperLowerCase = randomUpperLowerCase;
    }

    public String getText(String text) {

        String result = deleteSpaces.doDelete(text);
        result = punctuationRemoval.doRemove(result);
        result = randomPunctuation.doInsert(result);
        result = replaceDiacriticalMarks.doReplace(result);
        result = randomUpperLowerCase.doReplace(result);
        return result;
    }
}
