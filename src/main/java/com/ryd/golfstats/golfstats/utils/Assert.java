package com.ryd.golfstats.golfstats.utils;

public class Assert {

    public Assert() {
    }

    //for strings
    public static void notBlank(String argument, String argumentName) {
        if (argument == null || argument.isEmpty() || argument.trim().isEmpty()) {
            throwException("'%s' must not be blank", argumentName);
        }
    }

    //for objects
    public static <T> void notNull(T argument, String argumentName) {
        if (argument == null) {
            throwException("'%s' must not be null", argumentName);
        }

    }

    private static void throwException(String message, String argumentName) {
        throw new IllegalArgumentException(String.format(message, argumentName));
    }

}
