package com.nativehappenings.happenings.api.payload.response;

public class MessageResponse {

    private String message;

    // CONSTRUCTORS
    public MessageResponse(String message) {
        this.message = message;
    }

    // GETTERS AND SETTERS
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
