package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public StringForSecondThreadTooShortException(Throwable cause) {
        super(cause);
    }
}
