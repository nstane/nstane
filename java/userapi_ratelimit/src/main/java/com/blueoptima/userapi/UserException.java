package com.blueoptima.userapi;

public class UserException extends RuntimeException {
    public static final String USER_MISSING = "USER_DETAILS_MISSING";

    private final String errorCode;

    public UserException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
