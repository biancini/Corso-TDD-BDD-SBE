package bnsit.tdd.intro;

public class MissingLanguageVersionException extends StringI18nException {

	public MissingLanguageVersionException() {
		super();
	}

	public MissingLanguageVersionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MissingLanguageVersionException(String message, Throwable cause) {
		super(message, cause);
	}

	public MissingLanguageVersionException(String message) {
		super(message);
	}

	public MissingLanguageVersionException(Throwable cause) {
		super(cause);
	}
}
