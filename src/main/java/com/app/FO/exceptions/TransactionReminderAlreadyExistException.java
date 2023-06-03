package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class TransactionReminderAlreadyExistException extends RuntimeException {
    public TransactionReminderAlreadyExistException(String message) {
        super(message);
    }
}
