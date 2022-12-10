package cn.tedu.spring.exception;

public class DeleteFailedException extends RuntimeException{
    public DeleteFailedException() {
    }

    public DeleteFailedException(String message) {
        super(message);
    }

    public DeleteFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteFailedException(Throwable cause) {
        super(cause);
    }

    public DeleteFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
