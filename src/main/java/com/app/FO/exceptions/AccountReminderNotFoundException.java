package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AccountReminderNotFoundException extends RuntimeException {
    public AccountReminderNotFoundException(String message) {
        super(message);
    }
}
