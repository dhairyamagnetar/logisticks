package com.example.logisticks.controllers;

import com.example.logisticks.dao.RateDAO;
import com.example.logisticks.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RateController {
    @Autowired
    private RateDAO rDAO;

    @PostMapping("/rate/calculate")
    public float getRate(@RequestBody OrderRequest orderRequest) {
        return rDAO.calculateRate(orderRequest);
    }
}
