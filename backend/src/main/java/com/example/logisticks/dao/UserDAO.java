package com.example.logisticks.dao;
import com.example.logisticks.models.User;

public interface UserDAO {
    boolean signIn(String phoneNumber, String password);
    boolean signUp(String phoneNumber, String password, String name, String houseNumber, String locality, int locationId);
}
