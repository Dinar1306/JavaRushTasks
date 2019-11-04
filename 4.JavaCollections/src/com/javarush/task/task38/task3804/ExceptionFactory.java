package com.javarush.task.task38.task3804;

public class ExceptionFactory {
        public static Throwable createException(Enum exceptionEnum) {
            if (exceptionEnum == null)
                return new IllegalArgumentException();

            String message = exceptionEnum.name().charAt(0) + exceptionEnum.name().substring(1).toLowerCase().replace("_", " ");

            if (exceptionEnum instanceof ApplicationExceptionMessage)
                return new Exception(message);

            if (exceptionEnum instanceof DatabaseExceptionMessage)
                return new RuntimeException(message);

            if (exceptionEnum instanceof UserExceptionMessage)
                return new Error(message);

            return new IllegalArgumentException();
        }
}
