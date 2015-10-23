package szkolenie.cwiczenie_07;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class PunctuationRemoval {
    public String doRemove(String s) {
        return s.replaceAll("[;.:!?,]", "");
    }
}
