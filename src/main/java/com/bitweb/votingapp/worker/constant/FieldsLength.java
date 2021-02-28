package com.bitweb.votingapp.worker.constant;

public final class FieldsLength {

    public static final int ANSWER_DESCRIPTION = 500;
    public static final int ANSWER_TEXT = 255;
    public static final int QUESTION_DESCRIPTION = 500;
    public static final int QUESTION_TEXT = 255;
    public static final int SURVEY_DESCRIPTION = 1000;
    public static final int SURVEY_NAME = 255;

    private FieldsLength() {
        throw new UnsupportedOperationException(
                "This is a constants class and cannot be instantiated");
    }
}
