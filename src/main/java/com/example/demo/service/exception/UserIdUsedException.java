package com.example.demo.service.exception;

public class UserIdUsedException extends ServiceException{
    public UserIdUsedException() {
        super();
    }

    public UserIdUsedException(String message) {
        super(message);
    }

    public UserIdUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIdUsedException(Throwable cause) {
        super(cause);
    }

    protected UserIdUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
