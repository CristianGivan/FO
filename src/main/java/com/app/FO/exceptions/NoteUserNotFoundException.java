package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoteUserNotFoundException extends RuntimeException {
    public NoteUserNotFoundException(String message) {
        super(message);
    }
}
