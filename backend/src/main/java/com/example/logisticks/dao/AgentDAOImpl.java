package com.example.logisticks.dao;

import com.example.logisticks.models.Address;
import com.example.logisticks.models.User;
import com.example.logisticks.utilities.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.logisticks.models.Agent;
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
}
