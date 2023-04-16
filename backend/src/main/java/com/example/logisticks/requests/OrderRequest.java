package com.example.logisticks.requests;

import java.time.LocalDateTime;

public class OrderRequest {
    private int id;
    private float deliveryRate;

    public void setId(int id) {
        this.id = id;
    }

    public void setDeliveryRate(float deliveryRate) {
        this.deliveryRate = deliveryRate;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public float getDeliveryRate() {
        return deliveryRate;
    }

    public float getWeight() {
        return weight;
    }

    public int getIsFragile() {
        return isFragile;
    }

    public int getIsExpressDelivery() {
        return isExpressDelivery;
    }

    public String getSenderPhoneNumber() {
        return senderPhoneNumber;
    }

//    public LocalDateTime getOrderTime() {
//        return orderTime;
//    }

//    public LocalDateTime getTimeOfReceipt() {
//        return timeOfReceipt;
//    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setIsFragile(int isFragile) {
        this.isFragile = isFragile;
    }

    public void setIsExpressDelivery(int isExpressDelivery) {
        this.isExpressDelivery = isExpressDelivery;
    }

    public void setSenderPhoneNumber(String senderPhoneNumber) {
        this.senderPhoneNumber = senderPhoneNumber;
    }

//    public void setOrderTime(LocalDateTime orderTime) {
//        this.orderTime = orderTime;
//    }

//    public void setTimeOfReceipt(LocalDateTime timeOfReceipt) {
//        this.timeOfReceipt = timeOfReceipt;
//    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    private float weight;
    private int isFragile;
    private int isExpressDelivery;
    private String senderPhoneNumber;

//    private LocalDateTime timeOfReceipt;
    private String receiverPhoneNumber;
}
