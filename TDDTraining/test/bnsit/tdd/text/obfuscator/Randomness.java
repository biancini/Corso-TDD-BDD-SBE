package bnsit.tdd.text.obfuscator;

import java.util.Random;

public class Randomness {

	private Random random = new Random();
	
	public boolean shouldBeDoneWith(double probability) {
		return random.nextDouble() < probability;
	}

}
