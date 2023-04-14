package com.example.logisticks.dao;
import com.example.logisticks.models.ToBeReceivedBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ToBeReceivedByimpl implements ToBeReceivedByDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(ToBeReceivedBy receive) {
        return jdbcTemplate.update("insert into ToBeReceivedBy(orderId, receiverPhoneNumber, timeofReceipt, ReceptionOTP) values (?, ?, ?, ?)", receive.getOrderId(), receive.getReceiverPhoneNumber(), receive.getTimeOfReceipt(), receive.getReceptionOTP());
    }

    @Override
    public int update(ToBeReceivedBy receive, int orderId) {
        return jdbcTemplate.update("update ToBeReceivedBy set receiverPhoneNumber = ?, timeofReceipt = ?, ReceptionOTP = ? where orderId = ?", receive.getReceiverPhoneNumber(), receive.getTimeOfReceipt(), receive.getReceptionOTP(),orderId);
    }
}