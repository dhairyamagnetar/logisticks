package com.example.logisticks.requests;

public class SignUpRequest {
    private String phoneNumber;
    private String password;
    private String name;
    private String houseNumber;
    private String locality;
    private int locationId;

    private String vehicleNumber;
    private int salary;

    public SignUpRequest(String phoneNumber, String password, String name, String houseNumber, String locality, int locationId, String vehicleNumber, int salary) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.name = name;
        this.houseNumber = houseNumber;
        this.locality = locality;
        this.locationId = locationId;
        this.vehicleNumber = vehicleNumber;
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
