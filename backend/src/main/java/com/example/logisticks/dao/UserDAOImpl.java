package com.example.logisticks.dao;
import com.example.logisticks.models.User;
import org.apache.tomcat.Jar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public boolean signIn(String phoneNumber, String password) {
        return false;
    }

    @Override
    public boolean signUp(String phoneNumber,
                          String password,
                          String name,
                          String houseNumber,
                          String locality,
                          String locationId
    ){
        return false;
    }
}
