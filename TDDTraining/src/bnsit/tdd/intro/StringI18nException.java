package bnsit.tdd.intro;

public class StringI18nException extends RuntimeException {

	public StringI18nException() {
		super();
	}

	public StringI18nException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StringI18nException(String message, Throwable cause) {
		super(message, cause);
	}

	public StringI18nException(String message) {
		super(message);
	}

	public StringI18nException(Throwable cause) {
		super(cause);
	}
}
