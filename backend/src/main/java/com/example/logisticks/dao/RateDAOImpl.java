package com.example.logisticks.dao;

import com.example.logisticks.models.Rate;
import com.example.logisticks.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RateDAOImpl implements RateDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public float calculateRate(OrderRequest orderRequest) {
        float price = 0;

        String sql = "select baseRate from rate where fromLocationId = " + orderRequest.getSenderLocationId() + " and toLocationId = " + orderRequest.getReceiverLocationId();

        try {
            System.out.println(sql);
            Rate rate = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Rate>(Rate.class));
            orderRequest.setDeliveryRate(Math.min(rate.getBaseRate(),(rate.getBaseRate())*(orderRequest.getWeight())));
            price += Math.min(rate.getBaseRate(),(rate.getBaseRate())*(orderRequest.getWeight()));
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(price);
        }


        if (orderRequest.getIsExpressDelivery() == 1) {
            price += 100;
        }

        if (orderRequest.getIsFragile() == 1) {
            price += 50;
        }

        return price;
    }
}
