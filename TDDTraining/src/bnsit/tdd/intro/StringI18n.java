package bnsit.tdd.intro;

import java.util.HashMap;
import java.util.Map;

public class StringI18n {

	private Map<String, String> versions = new HashMap<String, String>();
	private String defaultLanguageVersion;
	
	public StringI18n(String countryCode, String languageVersion) {
		add(countryCode, languageVersion);
		defaultLanguageVersion = countryCode;
	}

	public void add(String countryCode, String languageVersion) {
		versions.put(countryCode, languageVersion);
	}

	public String get(String countryCode) {
		if (!versions.containsKey(countryCode)) {
			throw new MissingLanguageVersionException("Missing language version " + countryCode);
		}
		
		return versions.get(countryCode);
	}

	public String get() {
		return get(defaultLanguageVersion);
	}
}
