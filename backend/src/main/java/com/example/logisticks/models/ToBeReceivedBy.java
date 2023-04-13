package com.example.logisticks.models;
import java.time.LocalDateTime;
import java.lang.Math;
public class ToBeReceivedBy {
    private int orderId;
    private LocalDateTime timeOfReceipt;
    private String receiverPhoneNumber;
    private int receptionOTP;
    public ToBeReceivedBy(int orderId, LocalDateTime timeOfReceipt, String receiverPhoneNumber, int receptionOTP) {
        this.orderId = orderId;
        this.timeOfReceipt = timeOfReceipt;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receptionOTP = receptionOTP;
    }

    public int getOrderId() {
        return orderId;
    }

    public LocalDateTime getTimeOfReceipt() {
        return timeOfReceipt;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public int getReceptionOTP() {
        return receptionOTP;
    }

    public void generateOTP(){
        this.receptionOTP = (int) (Math.random()*8999 + 1000);
    }

}
