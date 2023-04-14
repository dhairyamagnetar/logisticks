package com.example.logisticks.dao;
import com.example.logisticks.models.User;

public interface UserDAO {
    int signIn(String phoneNumber, String password);
    int signUp(String phoneNumber, String password, String name, String houseNumber, String locality, int locationId);
}
