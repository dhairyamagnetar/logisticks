package com.example.logisticks.models;

public class ToBeDeliveredBy {
    private String agentPhoneNumber;
    private int orderId;

    public ToBeDeliveredBy(String agentPhoneNumber, int orderId) {
        this.agentPhoneNumber = agentPhoneNumber;
        this.orderId = orderId;
    }
    public String getAgentPhoneNumber() {
        return agentPhoneNumber;
    }
    public int getOrderId() {
        return orderId;
    }
}
