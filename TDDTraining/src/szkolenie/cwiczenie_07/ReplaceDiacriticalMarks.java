package szkolenie.cwiczenie_07;

import java.util.HashMap;

/**
 * Created by Maciej Łabędzki
 * Date: 20.10.15
 */
public class ReplaceDiacriticalMarks {

    private final HashMap<Character, Character> map;

    public ReplaceDiacriticalMarks() {

        this.map = new HashMap<Character, Character>();
        map.put('Ą', 'A');
        map.put('Ć', 'C');
        map.put('Ę', 'E');
        map.put('Ł', 'L');
        map.put('Ń', 'N');
        map.put('Ó', 'O');
        map.put('Ś', 'S');
        map.put('Ź', 'Z');
        map.put('Ż', 'Z');
        map.put('ą', 'a');
        map.put('ć', 'c');
        map.put('ę', 'e');
        map.put('ł', 'l');
        map.put('ń', 'n');
        map.put('ó', 'o');
        map.put('ś', 's');
        map.put('ź', 'z');
        map.put('ż', 'z');
    }

    public String doReplace(String input) {

        String result = input;

        for (Character c : this.map.keySet()) {
            result = result.replace(c, this.map.get(c));
        }

        return result;
    }
}
