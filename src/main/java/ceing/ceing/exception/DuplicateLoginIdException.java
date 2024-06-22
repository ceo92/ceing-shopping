package ceing.ceing.exception;

public class DuplicateLoginIdException extends RuntimeException {

  public DuplicateLoginIdException() {
  }

  public DuplicateLoginIdException(String message) {
    super(message);
  }

  public DuplicateLoginIdException(String message, Throwable cause) {
    super(message, cause);
  }

  public DuplicateLoginIdException(Throwable cause) {
    super(cause);
  }

  public DuplicateLoginIdException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
