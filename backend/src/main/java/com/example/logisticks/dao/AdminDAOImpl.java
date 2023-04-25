package com.example.logisticks.dao;

import com.example.logisticks.models.OrderListTile;
import com.example.logisticks.models.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AdminDAOImpl implements AdminDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<OrderListTile> fetchAllOrders() {
        List<OrderListTile> orders = new ArrayList<OrderListTile>();
        try{
            String sql = "select id,deliveryRate, weight, isFragile, isExpressDelivery, status from orders o inner join orderstatus s on o.id = s.orderId where s.status in (0,1,2)";
            orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<OrderListTile>(OrderListTile.class));
            return orders;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orders;
    }
    @Override
    public boolean updateOrderStatus(int orderId, OrderStatus.Status orderStatus, int locationId) {
        try{
            String sql = "update orderstatus set status = ?, currentLocationId = ? where orderId = ?";
            jdbcTemplate.update(sql, orderStatus.getValue(), locationId, orderId);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
