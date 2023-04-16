package com.example.logisticks.dao;

import com.example.logisticks.models.Order;

import java.util.List;

public interface AdminDAO {
    List<Order> fetchAllOrders();
    int updateOrderStatus(int orderId, int orderStatus, int locationId);
}
