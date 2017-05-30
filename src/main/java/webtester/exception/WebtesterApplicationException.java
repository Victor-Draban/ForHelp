package webtester.exception;

public class WebtesterApplicationException extends RuntimeException {
	private static final long serialVersionUID = -486309936771297062L;

	public WebtesterApplicationException(String message) {
		super(message);
	}

	public WebtesterApplicationException(Throwable cause) {
		super(cause);
	}

	public WebtesterApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
}
