package szkolenie.cwiczenie_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class StringI18n {
    private final Map<String, String> versions = new HashMap<String, String>();
    private String defaultVersion;

    public StringI18n(String countryCode, String value) {

        add(countryCode, value);
    }

    public void add(String countryCode, String value) {

        if (this.versions.isEmpty()) {
            this.defaultVersion = value;
        }
        this.versions.put(countryCode, value);
    }

    public String get(String countryCode) {

        String result = this.versions.get(countryCode);

        if (result == null) {
            throw new StringI18nException("no version for countryCode: " + countryCode);
        }

        return result;
    }

    public String get() {

        return this.defaultVersion;
    }
}
