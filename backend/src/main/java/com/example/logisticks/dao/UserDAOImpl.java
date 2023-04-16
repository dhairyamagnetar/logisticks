package com.example.logisticks.dao;
import com.example.logisticks.models.Address;
import com.example.logisticks.models.User;
import com.example.logisticks.utilities.Auth;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private AddressDAO aDAO;
    @Override
    public int signIn(String phoneNumber, String password) {
        try{
            User user = jdbcTemplate.queryForObject("select * from user where phoneNumber = ?", new Object[]{phoneNumber}, new BeanPropertyRowMapper<User>(User.class));
            boolean auth =  user.matchPassword(password);
            if(auth){
                int key = (int) (Math.random()*89999999 + 10000000);
                Auth.setKey(key);
                return key;
            }return 0;
        }catch(Exception e){
            return 0;
        }
    }
    @Override
    public int signUp(String phoneNumber,
                          String password,
                          String name,
                          String houseNumber,
                          String locality,
                          int locationId
    ){
        int found = 0;
        try{
            User user = jdbcTemplate.queryForObject("select * from user where phoneNumber=?",new Object[]{phoneNumber}, new BeanPropertyRowMapper<User>(User.class));
            if(user.getPhoneNumber().equals(phoneNumber)) found++;
        }catch(Exception e){
            System.out.println("Some error occurred while performing the checks.");
        }
        if(found > 0){
            try{
                Address address = new Address(houseNumber, locality, locationId);
                int addressId = aDAO.save(address);
                User user = new User(phoneNumber, name, addressId, 0, password);
                int rows = jdbcTemplate.update("update user set name = ?, addressId = ?, isAdmin = ?, passwordHash = ? where phoneNumber = ?", user.getName(), user.getAddressId(), user.getIsAdmin(), user.getPasswordHash(), user.getPhoneNumber());
                if(rows > 0){
                    int key = (int) (Math.random()*89999999 + 10000000);
                    Auth.setKey(key);
                    return key;
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
                return 0;
            }
        }else {
            try{
                Address address = new Address(houseNumber, locality, locationId);
                int addressId = aDAO.save(address);
                User user = new User(phoneNumber, name, addressId, 0, password);
                int rows = jdbcTemplate.update("insert into user(phoneNumber, name, addressId, isAdmin, passwordHash) values (?, ?, ?, ?, ?)", user.getPhoneNumber(), user.getName(), user.getAddressId(), user.getIsAdmin(), user.getPasswordHash());
                if(rows > 0){
                    int key = (int) (Math.random()*89999999 + 10000000);
                    Auth.setKey(key);
                    return key;
                }
            }catch(Exception e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }
        return 0;
    }

    @Override
    public List<Order> getSentOrders(String phoneNumber) {
        //String sql = "select";
        ///List<Order> ret = jdbcTemplate.query();
        return null;
    }

}
