package org.kuroneko.starpivot.entity.response;

import org.springframework.http.HttpStatus;

public class Response {
    private String data;
    private int statusCode;

    public Response(String data, int statusCode) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public Response(String data, HttpStatus status) {
        this.data = data;
        this.statusCode = status.value();
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
