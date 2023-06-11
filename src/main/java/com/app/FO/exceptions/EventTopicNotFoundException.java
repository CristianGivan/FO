package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventTopicNotFoundException extends RuntimeException {
    public EventTopicNotFoundException(String message) {
        super(message);
    }
}
