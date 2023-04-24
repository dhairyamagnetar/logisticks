package com.example.logisticks.dao;
import com.example.logisticks.models.OrderListTile;
import com.example.logisticks.requests.OrderRequest;
import com.example.logisticks.responses.OrderResponse;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderDAO {
    public OrderResponse placeOrder(OrderRequest req);

    List<OrderListTile> getSentOrders(String phoneNumber);
    List<OrderListTile> getReceivedOrders(String phoneNumber);
}
