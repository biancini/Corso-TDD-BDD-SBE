package bnsit.tdd.text.obfuscator;

public class Obfuscations {

	private static final double LOW_PROBABILITY = 0.2;
	private Randomness randomness = new Randomness();

	public Obfuscations() {
	}
	
	public Obfuscations(Randomness randomness) {
		this.randomness = randomness;
	}

	public String removeSpace(String text) {
		return text.replace(" ", "");
	}

	public String replaceLowerAndUppercaseRandomly(String text) {
		String result = "";
		char[] singleCharacters = text.toCharArray();
		for (char c : singleCharacters) {
			if (randomness.shouldBeDoneWith(LOW_PROBABILITY)) {
				if (Character.isUpperCase(c)) {
					result += Character.toLowerCase(c);
				} else {
					result += Character.toUpperCase(c);
				}
			} else {
				result += c;
			}
		}
		
		return result;
	}

	@SuppressWarnings("deprecation")
	public String insertPunctuationRandomly(String text) {
		String result = "";
		char[] singleCharacters = text.toCharArray();
		for (char c : singleCharacters) {
			if (Character.isWhitespace(c) 
					&& randomness.shouldBeDoneWith(LOW_PROBABILITY)) {
				result += "!"; // random punctuation marks
			} else {
				result += c;
			}
		}
		
		return result;
	}

}
