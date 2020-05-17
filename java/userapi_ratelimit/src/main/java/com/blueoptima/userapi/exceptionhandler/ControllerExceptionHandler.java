package com.blueoptima.userapi.exceptionhandler;

import com.blueoptima.userapi.UserException;
import com.blueoptima.userapi.ratelimit.exception.RateLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RateLimitException> handlerRateLimitException(RateLimitException e) {
        return new ResponseEntity(e, HttpStatus.TOO_MANY_REQUESTS);
    }

    @ExceptionHandler
    public ResponseEntity<UserException> handlerRateLimitException(UserException e) {
        return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
    }

    @ExceptionHandler
    public ResponseEntity<RateLimitException> handlerRateLimitException(Exception e) {
        return new ResponseEntity(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
