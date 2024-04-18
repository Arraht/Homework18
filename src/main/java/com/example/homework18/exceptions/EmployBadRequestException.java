package com.example.homework18.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployBadRequestException extends RuntimeException {
    public EmployBadRequestException(String message) {
        super(message);
    }
}