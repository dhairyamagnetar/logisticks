package com.example.logisticks.dao;

import com.example.logisticks.models.*;
import com.example.logisticks.requests.AgentRequest;
import com.example.logisticks.responses.AgentResponse;
import com.example.logisticks.responses.OrderResponse;
import com.example.logisticks.utilities.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class AgentDAOImpl implements AgentDAO{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private AddressDAO aDAO;
    @Override
    public int signIn(String phoneNumber, String password) {
        try{
            Agent agent = jdbcTemplate.queryForObject("select * from agent where phoneNumber = ?", new Object[]{phoneNumber}, new BeanPropertyRowMapper<Agent>(Agent.class));

            boolean auth =  agent.matchPassword(password);
            if(auth){
                int key = (int) (Math.random()*89999999 + 10000000);
                Auth.mp.put(phoneNumber, key);
                Auth.isAdmin.put(phoneNumber, agent.getIsAdmin());
                return key;
            }return 0;
        }catch(Exception e){
            return 0;
        }
    }
    @Override
    public int signUp(String phoneNumber, String password, String name, String houseNumber, String locality, int locationId, String vehicleNumber, int salary) {
        try{
            Address address = new Address(houseNumber, locality, locationId);
            int addressId = aDAO.save(address);
            int vnum = (int) (Math.random()*(9999-1000) + 1000000);
            vehicleNumber = String.valueOf(vnum);
            Agent agent = new Agent(phoneNumber, name, addressId, 0, password, locationId, vehicleNumber, salary);
            int rows = jdbcTemplate.update("insert into agent(phoneNumber, name, addressId, isAdmin, passwordHash, locationId, vehicleNumber, salary) values (?, ?, ?, ?, ?, ?, ?, ?)", agent.getPhoneNumber(), agent.getName(), agent.getAddressId(), agent.getIsAdmin(), agent.getPasswordHash(), agent.getLocationId(), agent.getVehicleNumber(), agent.getSalary());
            if(rows > 0){
                int key = (int) (Math.random()*89999999 + 10000000);
                Auth.mp.put(phoneNumber, key);
                return key;
            }
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
        return 0;
    }
    @Override
    public List<AgentAssignedOrder> viewAssignedOrders()
    {
        List<AgentAssignedOrder> orders = new ArrayList<AgentAssignedOrder>();
        try{
            String sql = "select o.id, o.weight, o.isFragile, o.isExpressDelivery,r.receiverPhoneNumber, concat(a.houseNumber,' ',a.locality,',',l.district,' ',l.city,' ',l.state) as receiver_address from orders o inner join tobereceivedby r on o.id = r.orderId inner join address a on a.id=o.id inner join location l on l.id=a.locationId;";
            orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AgentAssignedOrder>(AgentAssignedOrder.class));
            return orders;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return orders;
    }
    @Override
    public AgentResponse markAsDelivered(AgentRequest agentRequest)
    {
        AgentResponse res=new AgentResponse();
        // select * from orderstatus where orderId=enteredorderId;
        //if this is>0 then move forward else error
        int id=agentRequest.getId();
        int otp=agentRequest.getOTP();
        try {
            jdbcTemplate.update(conn -> {
                String sql = "update orderstatus set status=1 where (?) in (select r.orderId from tobereceivedby r where receptionOTP=(?) and r.orderId=(?))";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, id);
                stmt.setInt(2, otp);
                stmt.setInt(3, id);
                return stmt;
            });
        }catch(Exception e)
        {
            System.out.println("Error in updating order status");
            System.out.println(e);
            res.setMessage("Error in updating order status!");
            res.setStatus(false);
            return res;
        }
        String sql_delete="delete from tobedeliveredby where orderId=(?)";
        try {
            jdbcTemplate.update(con -> {
                PreparedStatement statment = con.prepareStatement(sql_delete);
                statment.setInt(1, id);
                return statment;
            });
        }catch(Exception e)
        {
            System.out.println("Error in deleting tobedeliveredby table");
            System.out.println(e);
            res.setMessage("Error in deleting tobedeliveredby table!");
            res.setStatus(false);
            return res;
        }
        res.setMessage("Error made changes");
        res.setStatus(true);
        return res;
    }

}
