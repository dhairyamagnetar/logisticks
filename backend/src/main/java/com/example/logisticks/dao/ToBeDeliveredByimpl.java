package com.example.logisticks.dao;
import com.example.logisticks.models.ToBeDeliveredBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ToBeDeliveredByimpl implements ToBeDeliveredByDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(ToBeDeliveredBy deliver) {
        return jdbcTemplate.update("insert into ToBeDeliveredBy(orderId, agentPhoneNumber) values (?, ?)", deliver.getOrderId(),deliver.getAgentPhoneNumber());
    }

    @Override
    public int update(SentBy sentby, int orderId) {
        return jdbcTemplate.update("update ToBeDeliveredBy set agentPhoneNumber = ? where orderId = ?", deliver.getAgentPhoneNumber(), orderId);
    }
}


