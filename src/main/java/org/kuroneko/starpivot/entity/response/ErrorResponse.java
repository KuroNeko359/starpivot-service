package org.kuroneko.starpivot.entity.response;

import org.springframework.http.HttpStatus;

public class ErrorResponse extends Response {

    public ErrorResponse(String message, HttpStatus status) {
        super(message, status);
    }
}
