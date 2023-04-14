package com.example.logisticks.models;

public class Order {
    private int id;
    private float deliveryRate;
    private float weight;
    private int isFragile;
    private int isExpressDelivery;

    public Order(int id, float deliveryRate, float weight, int isFragile, int isExpressDelivery) {
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

    public int isFragile() {
        return isFragile;
    }

    public int isExpressDelivery() {
        return isExpressDelivery;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDeliveryRate(float deliveryRate) {
        this.deliveryRate = deliveryRate;
    }
}
