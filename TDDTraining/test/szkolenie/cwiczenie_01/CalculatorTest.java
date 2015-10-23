package szkolenie.cwiczenie_01;

import org.junit.Assert;
import org.junit.Test;
import szkolenie.cwiczenie_01.Calculator;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class CalculatorTest {

    @Test
    public void shouldAddTwoIntegers() {

        //setup
        Calculator calculator = new Calculator();

        // invocation
        int result = calculator.add(4, 5);

        // asserts
        Assert.assertEquals(9, result);

        // teardown
    }


    @Test(expected = CalculatorException.class)
    public void shouldThrowExceptionWhenDivisionByZero() throws CalculatorException {

        Calculator calculator = new Calculator();

        double result = calculator.divide(10,0);

        // expect exception

    }


    @Test(expected = CalculatorException.class)
    public void shouldThrowExceptionWhenRangeExceeded() {

        Calculator calculator = new Calculator();

        int result = calculator.add(Integer.MAX_VALUE, Integer.MAX_VALUE);

        System.out.println(result);
        // expect exception
    }

    @Test(expected = CalculatorException.class)
    public void shouldThrowExceptionWhenRangeExceededNegative() {

        Calculator calculator = new Calculator();

        int result = calculator.add((-1) * Integer.MAX_VALUE, (-1) * Integer.MAX_VALUE);

        System.out.println(result);
        // expect exception
    }
}
