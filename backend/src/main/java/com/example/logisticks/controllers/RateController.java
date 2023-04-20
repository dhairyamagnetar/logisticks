package com.example.logisticks.controllers;

import com.example.logisticks.dao.RateDAO;
import com.example.logisticks.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RateController {
    @Autowired
    private RateDAO rDAO;

    @GetMapping("/rate/calculate")
    public float getRate(@RequestBody OrderRequest orderRequest) {
        return rDAO.calculateRate(orderRequest);
    }
}
