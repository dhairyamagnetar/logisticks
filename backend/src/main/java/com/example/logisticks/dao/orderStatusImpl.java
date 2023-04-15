package com.example.logisticks.dao;

import com.example.logisticks.models.OrderStatus;
import org.springframework.stereotype.Repository;

@Repository
public class orderStatusImpl implements  orderStatusDAO {
    @Override
    public void  updateStatus(OrderStatus orderStatus, OrderStatus.Status newStatus) {
        orderStatus.setStatus(newStatus);
    }

    @Override
    public void  updateLocationId(OrderStatus orderStatus, int newLocationId) {
        orderStatus.setCurrentLocationId(newLocationId);
    }
}
