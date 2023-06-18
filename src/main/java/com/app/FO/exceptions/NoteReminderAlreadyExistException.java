package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class NoteReminderAlreadyExistException extends RuntimeException {
    public NoteReminderAlreadyExistException(String message) {
        super(message);
    }
}
