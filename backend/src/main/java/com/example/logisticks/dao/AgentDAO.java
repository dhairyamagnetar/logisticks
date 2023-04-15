package com.example.logisticks.dao;

public interface AgentDAO {
    int signIn(String phoneNumber, String password);
    int signUp(String phoneNumber, String password, String name, String houseNumber, String locality, int locationId, String vehicleNumber, int salary);

}
