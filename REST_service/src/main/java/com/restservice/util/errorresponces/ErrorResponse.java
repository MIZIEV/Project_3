package com.restservice.util.errorresponces;

public class ErrorResponse {
    private String errorMessage;
    private long timeStamp;

    public ErrorResponse(String errorMessage, long timeStamp) {
        this.errorMessage = errorMessage;
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}