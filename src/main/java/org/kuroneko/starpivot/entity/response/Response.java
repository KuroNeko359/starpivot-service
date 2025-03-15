package org.kuroneko.starpivot.entity.response;

import org.springframework.http.HttpStatus;

public class Response {
    private String message;
    private int statusCode;

    public Response(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public Response(String message, HttpStatus status) {
        this.message = message;
        this.statusCode = status.value();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
