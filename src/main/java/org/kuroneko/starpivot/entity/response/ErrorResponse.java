package org.kuroneko.starpivot.entity.response;

public class ErrorResponse extends Response {

    public ErrorResponse(String message, int statusCode) {
        super(message, statusCode);
    }
}
