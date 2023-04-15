package com.example.logisticks.dao;
import com.example.logisticks.models.Order;
import com.example.logisticks.requests.OrderRequest;

public interface OrderDAO {
    public boolean placeOrder(OrderRequest req);
}
