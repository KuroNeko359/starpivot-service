package org.kuroneko.starpivot.entity.response;

import org.springframework.http.HttpStatus;

public class SuccessResponse extends Response{

    public SuccessResponse(String message, HttpStatus status) {
        super(message, status);
    }
}
