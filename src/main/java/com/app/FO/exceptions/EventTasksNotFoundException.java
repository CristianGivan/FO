package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventTasksNotFoundException extends RuntimeException {
    public EventTasksNotFoundException(String message) {
        super(message);
    }
}
