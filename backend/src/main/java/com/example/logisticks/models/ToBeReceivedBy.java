package com.example.logisticks.models;
import java.time.LocalDateTime;
import java.lang.Math;
public class ToBeReceivedBy {
    private int orderId;
    private String timeOfReceipt;
    private String receiverPhoneNumber;
    private int receptionOTP;
    public ToBeReceivedBy(int orderId, String timeOfReceipt, String receiverPhoneNumber, int receptionOTP) {
        this.orderId = orderId;
        this.timeOfReceipt = timeOfReceipt;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receptionOTP = receptionOTP;
    }

    public ToBeReceivedBy() {
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setTimeOfReceipt(String timeOfReceipt) {
        this.timeOfReceipt = timeOfReceipt;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public void setReceptionOTP(int receptionOTP) {
        this.receptionOTP = receptionOTP;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getTimeOfReceipt() {
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
