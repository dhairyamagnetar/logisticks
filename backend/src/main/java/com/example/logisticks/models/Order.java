package com.example.logisticks.models;

public class Order {
    private int id;
    private float deliveryRate;
    private float weight;
    private boolean isFragile;
    private boolean isExpressDelivery;

    public Order(int id, float deliveryRate, float weight, boolean isFragile, boolean isExpressDelivery) {
        this.id = id;
        this.deliveryRate = deliveryRate;
        this.weight = weight;
        this.isFragile = isFragile;
        this.isExpressDelivery = isExpressDelivery;
    }
    public Order(){}

    public int getId() {
        return id;
    }

    public float getDeliveryRate() {
        return deliveryRate;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public boolean isExpressDelivery() {
        return isExpressDelivery;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeliveryRate(float deliveryRate) {
        this.deliveryRate = deliveryRate;
    }
}
