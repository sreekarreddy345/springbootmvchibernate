package com.sreekar.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidStudentIdException extends RuntimeException {

    public InvalidStudentIdException(String exception) {
        super(exception);
    }
}

