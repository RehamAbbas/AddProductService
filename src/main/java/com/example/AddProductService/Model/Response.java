package com.example.AddProductService.Model;

public class Response {

    private int status;
    private String message;

    public int getPort() {
        return port;
    }

    private int port;

    // Getter and setter methods
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
