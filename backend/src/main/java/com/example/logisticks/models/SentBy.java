package com.example.logisticks.models;
import java.time.LocalDateTime;

public class SentBy {
    private String senderPhoneNumber;
    private int orderId;
    private LocalDateTime orderTime;

    public SentBy(String senderPhoneNumber, int orderId, LocalDateTime orderTime) {
        this.senderPhoneNumber = senderPhoneNumber;
        this.orderId = orderId;
        this.orderTime = orderTime;
    }
    public SentBy(){}

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

}
