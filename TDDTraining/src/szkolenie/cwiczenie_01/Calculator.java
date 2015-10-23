package szkolenie.cwiczenie_01;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class Calculator {
    public int add(int first, int second) {

        long longValue = new Long(first) + new Long(second);
        if (longValue > Integer.MAX_VALUE || longValue < Integer.MIN_VALUE) {

            throw new CalculatorException("range exceeded");
        }

        return first + second;  //To change body of created methods use File | Settings | File Templates.
    }

    public double divide(int first, int second) {

        if (second == 0) {
            throw new CalculatorException("division by zero");
        }

        return 0;  //To change body of created methods use File | Settings | File Templates.
    }
}
