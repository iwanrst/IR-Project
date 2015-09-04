package com.ir.engine.com.ir.engine.util;

/**
 * Created by Iwan R on 8/30/2015.
 */
public class ResponseError {
    private String message;

    public ResponseError(String message, String... args) {
        this.message = String.format(message, args);
    }

    public ResponseError(Exception e) {
        this.message = e.getMessage();
    }

    public String getMessage() {
        return this.message;
    }
}
