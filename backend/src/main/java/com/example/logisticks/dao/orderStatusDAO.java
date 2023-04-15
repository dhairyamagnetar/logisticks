package com.example.logisticks.dao;

import com.example.logisticks.models.Order;
import com.example.logisticks.models.OrderStatus;

public interface orderStatusDAO {
    public void updateStatus(OrderStatus orderStatus, OrderStatus.Status newStatus);
    public void  updateLocationId(OrderStatus orderStatus, int newLocationId);
}
