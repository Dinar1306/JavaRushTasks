package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    public StringForFirstThreadTooShortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StringForFirstThreadTooShortException(Throwable cause) {
        super(cause);
    }
    @Override
    public synchronized Throwable getCause() {
        return new StringIndexOutOfBoundsException("String index out of range: -1");
    }
}
