package com.example.logisticks.dao;
import com.example.logisticks.models.SentBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SentByimpl implements SentByDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(SentBy sentby) {
        return jdbcTemplate.update("insert into SentBy(orderId, senderPhoneNumber, orderTime) values (?, ?, ?)", sentby.getOrderId() , sentby.getSenderPhoneNumber(), sentby.getOrderTime());
    }

    @Override
    public int update(SentBy sentby, int orderId) {
        return jdbcTemplate.update("update SentBy set orderTime = ?, senderPhoneNumber = ? where orderId = ?", sentby.getOrderTime(), sentby.getSenderPhoneNumber(), orderId);
    }
}
