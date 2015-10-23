package bnsit.bdd.calculator;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CalculatorSteps {

	private Calculator calculator;
	private int result;

	@Given("I have a calculator")
	public void setupCalculator() {
		calculator = new Calculator();
	}
	
	@When("I add $firstNumber and $secondNumber")
	public void addingTwoIntegers(int firstNumber, int secondNumber) {
		result = calculator.add(firstNumber, secondNumber);
	}
	
	@Then("I will get $expectedResult")
	public void checkAdditionResult(int expectedResult) {
		assertEquals(expectedResult, result);
	}
	
}
