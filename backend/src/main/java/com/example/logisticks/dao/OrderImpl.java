package com.example.logisticks.dao;

import com.example.logisticks.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.logisticks.dao.OrderDAO;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class OrderImpl implements OrderDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Lazy
    private OrderDAO oDAO;

    @Override
    public boolean placeOrder( Order order_rec ) {

        try {
            float deliveryRate = order_rec.getDeliveryRate();
            int isFragile = order_rec.isFragile();
            float weight = order_rec.getWeight();
            int isExpressDelivery = order_rec.isExpressDelivery();

            System.out.println(isFragile);


            Order order = new Order(deliveryRate, weight, isFragile, isExpressDelivery);
            String sql = "insert into orders(deliveryRate, weight, isFragile, isExpressDelivery) values(?, ?, ?, ?)";
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(conn -> {
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setFloat(1, deliveryRate);
                stmt.setFloat(2, weight);
                stmt.setInt(3, isFragile);
                stmt.setInt(4, isExpressDelivery);
                return stmt;
            }, generatedKeyHolder);

            order.setId(generatedKeyHolder.getKey().intValue());
            return true;
        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }
}
