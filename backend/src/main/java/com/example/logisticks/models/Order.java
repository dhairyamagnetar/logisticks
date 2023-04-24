package com.example.logisticks.models;

public class Order {
    protected int id;
    protected float deliveryRate;
    protected float weight;
    protected int isFragile;
    protected int isExpressDelivery;

    public Order(int id, float deliveryRate, float weight, int isFragile, int isExpressDelivery) {
        this.id = id;
        this.deliveryRate = deliveryRate;
        this.weight = weight;
        this.isFragile = isFragile;
        this.isExpressDelivery = isExpressDelivery;
    }

    public Order(float deliveryRate, float weight, int isFragile, int isExpressDelivery) {
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

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setIsFragile(int isFragile) {
        this.isFragile = isFragile;
    }

    public void setIsExpressDelivery(int isExpressDelivery) {
        this.isExpressDelivery = isExpressDelivery;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", deliveryRate=" + deliveryRate +
                ", weight=" + weight +
                ", isFragile=" + isFragile +
                ", isExpressDelivery=" + isExpressDelivery +
                '}';
    }

    public int getIsFragile() {
        return isFragile;
    }

    public int getIsExpressDelivery() {
        return isExpressDelivery;
    }
}
