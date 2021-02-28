package com.bitweb.votingapp.worker.constant;

public final class Milliseconds {
    public static final long SECOND = 1000L;
    public static final long MINUTE = 60_000L;

    private Milliseconds() {
        throw new UnsupportedOperationException(
                "This is a constants class and cannot be instantiated");
    }
}
