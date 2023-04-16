package com.example.logisticks.dao;
import com.example.logisticks.models.Order;
import com.example.logisticks.requests.OrderRequest;
import com.example.logisticks.responses.OrderResponse;

public interface OrderDAO {
    public OrderResponse placeOrder(OrderRequest req);
}
