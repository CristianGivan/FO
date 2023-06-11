package com.app.FO.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UserHasNotEnoughPrivileges extends RuntimeException {
    public UserHasNotEnoughPrivileges(String message) {
        super(message);
    }
}
