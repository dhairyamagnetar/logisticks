package com.example.logisticks.controllers;

import com.example.logisticks.dao.AdminDAO;
import com.example.logisticks.models.OrderListTile;
import com.example.logisticks.models.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminDAO aDAO;

    @GetMapping("/admin/orders")
    List<OrderListTile> getOrders(){
        return aDAO.fetchAllOrders();
    }

    @PostMapping("/admin/update")
    boolean updateOrder(@RequestBody OrderStatus orderStatus){
        return aDAO.updateOrderStatus(orderStatus.getOrderId(), orderStatus.getStatus(), orderStatus.getCurrentLocationId());
    }
}
