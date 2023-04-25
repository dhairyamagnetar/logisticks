package com.example.logisticks.models;

public class OrderListTile extends Order{
    private OrderStatus.Status status;

    public OrderListTile(int id, float deliveryRate, float weight, int isFragile, int isExpressDelivery, OrderStatus.Status status) {
        super(id, deliveryRate, weight, isFragile, isExpressDelivery);
        this.status = status;
    }
    public OrderListTile(){}

    public OrderStatus.Status getStatus() {
        return status;
    }

    public void setStatus(OrderStatus.Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderListTile{" +
                "status=" + status +
                ", id=" + id +
                ", deliveryRate=" + deliveryRate +
                ", weight=" + weight +
                ", isFragile=" + isFragile +
                ", isExpressDelivery=" + isExpressDelivery +
                '}';
    }
}
