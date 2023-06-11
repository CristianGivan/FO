package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WorkReminderNotFoundException extends RuntimeException {
    public WorkReminderNotFoundException(String message) {
        super(message);
    }
}
