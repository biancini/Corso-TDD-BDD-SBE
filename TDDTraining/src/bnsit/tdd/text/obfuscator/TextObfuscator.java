package bnsit.tdd.text.obfuscator;

public class TextObfuscator {

	private Obfuscations obfuscations;

	public TextObfuscator(Obfuscations obfuscations) {
		this.obfuscations = obfuscations;
	}

	public String obfuscate(String text) {
		String obfuscated = obfuscations.insertPunctuationRandomly(text);
		
		obfuscated = obfuscations.replaceLowerAndUppercaseRandomly(obfuscated);
		obfuscated = obfuscations.removeSpace(obfuscated);
		// other obfuscations
		
		return obfuscated;
	}

}
