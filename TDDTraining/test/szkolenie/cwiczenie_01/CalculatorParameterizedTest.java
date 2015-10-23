package szkolenie.cwiczenie_01;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
@RunWith(Parameterized.class)
public class CalculatorParameterizedTest {

    private int first;
    private int second;
    private int expectedResult;

    public CalculatorParameterizedTest(int first, int second, int expectedResult) {
        this.first = first;
        this.second = second;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection createParameters() {

        Object []parameters[] = new Object[][] {
            {1, 2, 1},
            {-1, 0, -1},
            {100, 1000, 100}
        };

        return Arrays.asList(parameters);
    }

    @Test
    public void shouldComputeMinimum() {

        Assert.assertEquals(this.expectedResult, Math.min(this.first, this.second));
    }

}
