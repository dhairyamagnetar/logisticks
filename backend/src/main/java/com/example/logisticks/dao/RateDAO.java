package com.example.logisticks.dao;

import com.example.logisticks.models.Rate;
import com.example.logisticks.requests.OrderRequest;

public interface RateDAO {
    public float calculateRate(OrderRequest orderRequest);
}
