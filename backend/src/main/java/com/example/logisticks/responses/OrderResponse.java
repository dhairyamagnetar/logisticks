package com.example.logisticks.responses;

public class OrderResponse {
    private boolean status;
    private String message;
    private float price;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMessage() {
        return message;
    }

    public float getPrice() {
        return price;
    }
}
