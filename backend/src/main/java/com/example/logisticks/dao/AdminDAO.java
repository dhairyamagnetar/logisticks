package com.example.logisticks.dao;

import com.example.logisticks.models.Order;
import com.example.logisticks.models.OrderListTile;
import com.example.logisticks.models.OrderStatus;

import java.util.List;

public interface AdminDAO {
    List<OrderListTile> fetchAllOrders();
    boolean updateOrderStatus(int orderId, OrderStatus.Status orderStatus, int locationId);
}
