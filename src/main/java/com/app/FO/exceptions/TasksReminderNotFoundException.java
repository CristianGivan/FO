package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TasksReminderNotFoundException extends RuntimeException {
    public TasksReminderNotFoundException(String message) {
        super(message);
    }
}
