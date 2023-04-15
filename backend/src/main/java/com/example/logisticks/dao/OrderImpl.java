package com.example.logisticks.dao;

import com.example.logisticks.models.Order;
import com.example.logisticks.models.SentBy;
import com.example.logisticks.models.ToBeReceivedBy;
import com.example.logisticks.requests.OrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.example.logisticks.dao.OrderDAO;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Repository
public class OrderImpl implements OrderDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Lazy
    private OrderDAO oDAO;

    @Override
    public boolean placeOrder(OrderRequest orderRequest) {

        try {

//            System.out.println(isFragile);

            float deliveryRate = orderRequest.getDeliveryRate();
            float weight = orderRequest.getWeight();
            int isFragile = orderRequest.getIsFragile();
            int isExpressDelivery = orderRequest.getIsExpressDelivery();
            String senderPhoneNumber = orderRequest.getSenderPhoneNumber();
            String receiverPhoneNumber = orderRequest.getReceiverPhoneNumber();
//            LocalDateTime timeOfReceipt = orderRequest.getTimeOfReceipt();
            LocalDateTime orderTime;

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
//            formatter.format(date);


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

            SentBy sentby = new SentBy(senderPhoneNumber, order.getId(), formatter.format(date));
            String sql_sentBy = "insert into sentBy(senderPhoneNumber, orderId, orderTime) values (?, ?, ?)";

            try {
                jdbcTemplate.update(con -> {
                    PreparedStatement stmt = con.prepareStatement(sql_sentBy);
                    stmt.setString(1,senderPhoneNumber);
                    stmt.setInt(2, order.getId());
                    stmt.setString(3, formatter.format(date));
                    return stmt;
                });
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }

            ToBeReceivedBy toBeReceivedBy = new ToBeReceivedBy(order.getId(), "", receiverPhoneNumber, -1);

            String sql_rec = "insert into toBeReceivedBy(orderId, receiverPhoneNumber) values (?, ?)";

            try {
                jdbcTemplate.update(con -> {
                    PreparedStatement stmt = con.prepareStatement(sql_sentBy);
                    stmt.setInt(1,order.getId());
                    stmt.setString(2, receiverPhoneNumber);
                    return stmt;
                });
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.print(e);
            return false;
        }
    }
}
