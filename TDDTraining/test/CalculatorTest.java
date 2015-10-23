import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	public void shouldAddTwoIntegers() {
		// invocation
		int result = calculator.add(4, 5);
		Assert.assertEquals(9, result);
		
		result = calculator.add(10, 5);
		assertEquals(15, result);
	}
	
	@Test(expected = CalculatorException.class)
	public void shouldThrowExceptinWhenUpperIntegerRangeExceededWhileAddingIntegers() {
		calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE);
	}

	@Test(expected = CalculatorException.class)
	public void shouldThrowExceptinWhenBottomIntegerRangeExceededWhileAddingIntegers() {
		calculator.add(Integer.MIN_VALUE, Integer.MIN_VALUE);
	}

	@Test(expected = CalculatorException.class)
	public void shouldThrownExceptionWhenDivisionByZero() {
		double result = calculator.divide(10, 0);
		
		// expect the exception
	}
}
