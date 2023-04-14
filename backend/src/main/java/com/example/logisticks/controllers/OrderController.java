package com.example.logisticks.controllers;

import com.example.logisticks.dao.OrderDAO;
import com.example.logisticks.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @Autowired
    private OrderDAO oDAO;

    @PostMapping("/order/placeorder")
    public boolean saveOrder(@RequestBody Order order) {
        return oDAO.placeOrder(order);
    }
}
