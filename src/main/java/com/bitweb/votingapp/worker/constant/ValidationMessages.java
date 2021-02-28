package com.bitweb.votingapp.worker.constant;

public final class ValidationMessages {
    public static final String MAX_LENGTH_EXCEEDED =
            "Value is longer than {max} characters";
    public static final String NOT_NULL =
            "Value must not be null";

    private ValidationMessages() {
        throw new UnsupportedOperationException(
                "This is a constants class and cannot be instantiated");
    }

}
