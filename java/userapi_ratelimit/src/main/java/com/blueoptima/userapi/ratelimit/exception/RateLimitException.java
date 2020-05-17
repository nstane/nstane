package com.blueoptima.userapi.ratelimit.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateLimitException extends RuntimeException {

    public static final String ERROR_CODE = "RATE_LIMIT_EXCEED";
    public static final String DEFAULT_LIMIT_MISSING = "DEFAULT_LIMIT_MISSING";
    private final String errorCode;

    public RateLimitException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return null;
    }
}
