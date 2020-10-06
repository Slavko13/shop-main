package ru.shop.base.exceptions;

import org.springframework.http.HttpStatus;

import java.util.Map;
import java.util.Set;

public class RequestException extends RuntimeException {

    private HttpStatus httpStatus;
    private Map<String, Set<String>> details;

    public RequestException(String message, Throwable cause, HttpStatus httpStatus, Map<String, Set<String>> details) {
        super(message, cause);
        this.httpStatus = httpStatus;
        this.details = details;
    }


}
