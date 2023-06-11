package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TheDayUserNotFoundException extends RuntimeException {
    public TheDayUserNotFoundException(String message) {
        super(message);
    }
}
