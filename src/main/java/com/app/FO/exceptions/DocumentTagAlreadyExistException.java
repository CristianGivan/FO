package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class DocumentTagAlreadyExistException extends RuntimeException {
    public DocumentTagAlreadyExistException(String message) {
        super(message);
    }
}
