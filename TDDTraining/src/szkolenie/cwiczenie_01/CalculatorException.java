package szkolenie.cwiczenie_01;

/**
 * Created by Maciej Łabędzki
 * Date: 19.10.15
 */
public class CalculatorException extends RuntimeException {

    public CalculatorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CalculatorException(Throwable cause) {
        super(cause);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException() {
    }
}
