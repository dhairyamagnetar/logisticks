package com.example.logisticks.models;

public class Agent extends User{
    private int locationId;
    private String vehicleNumber;
    private int salary;

    public Agent(String phoneNumber, String name, int addressId, int isAdmin, String password, int locationId, String vehicleNumber, int salary) {
        super(phoneNumber, name, addressId, isAdmin, password);
        this.locationId = locationId;
        this.vehicleNumber = vehicleNumber;
        this.salary = salary;
    }
    public Agent() {}

    public int getLocationId() {
        return locationId;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public int getSalary() {
        return salary;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
