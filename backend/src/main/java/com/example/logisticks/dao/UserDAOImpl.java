package com.example.logisticks.dao;
import com.example.logisticks.models.Address;
import com.example.logisticks.models.User;
import com.example.logisticks.utilities.Auth;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean signIn(String phoneNumber, String password) {
        try{
            User user = jdbcTemplate.queryForObject("select * from user where phoneNumber = ?", new Object[]{phoneNumber}, new BeanPropertyRowMapper<User>(User.class));
            boolean auth =  user.matchPassword(password);
            if(auth){
                Auth.setLoggedInUser(user);
                return true;
            }return false;
        }catch(Exception e){
            return false;
        }
    }
    @Override
    public boolean signUp(String phoneNumber,
                          String password,
                          String name,
                          String houseNumber,
                          String locality,
                          int locationId
    ){
        try{
            Address address = new Address(houseNumber, locality, locationId);
            int addressId = aDAO.save(address);
            User user = new User(phoneNumber, name, addressId, 0, password);
            int rows = jdbcTemplate.update("insert into user(phoneNumber, name, addressId, isAdmin, passwordHash) values (?, ?, ?, ?, ?)", user.getPhoneNumber(), user.getName(), user.getAddressId(), user.getIsAdmin(), user.getPasswordHash());
            if(rows > 0){
                Auth.setLoggedInUser(user);
                return true;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }
}
