package cn.tedu.spring.exception;

public class IllegalParameterException extends RuntimeException{

    public IllegalParameterException() {
    }

    public IllegalParameterException(String message) {
        super(message);
    }

    public IllegalParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParameterException(Throwable cause) {
        super(cause);
    }

    public IllegalParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
