
public class Calculator {

	public int add(int firstNumber, int secondNumber) {
		if ((long)firstNumber + (long)secondNumber > Integer.MAX_VALUE
				|| (long)firstNumber + (long)secondNumber < Integer.MIN_VALUE) {
			throw new CalculatorException("Integer range exceeded.");
		}
		
		return firstNumber + secondNumber;
	}

	public double divide(int firstNumber, int secondNumber) {
		if (secondNumber == 0) {
			throw new CalculatorException("Division by zero");
		}
		
		return 0;
	}

}
