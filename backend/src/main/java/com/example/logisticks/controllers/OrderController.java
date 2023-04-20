package com.example.logisticks.controllers;

import com.example.logisticks.dao.OrderDAO;
import com.example.logisticks.models.Order;
import com.example.logisticks.requests.OrderRequest;
import com.example.logisticks.responses.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderDAO oDAO;

    @PostMapping("/order/placeorder")
    public OrderResponse saveOrder(@RequestBody OrderRequest order) {
        return oDAO.placeOrder(order);
    }
}
