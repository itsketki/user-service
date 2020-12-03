package com.demo.user.exception;

/**
* <h1>Error Response</h1>
* The standard error response class to handle all error scenarios.
* <p>
*
* @author  Ketki Gupta
* @version 1.0
* @since   2020-12-03
*/
public class ErrorResponse {

    private int errorCode;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

