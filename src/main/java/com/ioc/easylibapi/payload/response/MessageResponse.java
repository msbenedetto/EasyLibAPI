package com.ioc.easylibapi.payload.response;

/**
 * Class MessageResponse
 * declares the message methods used to give a feedback to the end user
 */
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
