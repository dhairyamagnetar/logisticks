package com.example.logisticks.dao;
import com.example.logisticks.models.Order;
public interface OrderDAO {
    public boolean placeOrder(Order order);
}
