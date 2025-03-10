package org.kuroneko.starpivot.entity.response;

public class SuccessResponse extends Response{

    public SuccessResponse(String message, int statusCode) {
        super(message, statusCode);
    }
}
