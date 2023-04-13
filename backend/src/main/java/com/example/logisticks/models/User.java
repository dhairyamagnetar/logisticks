package com.example.logisticks.models;

public class User {
    private String phoneNumber;
    private String name;
    private int addressId;
    private int isAdmin;
    private String passwordHash;

    public User(String phoneNumber, String name, int addressId, int isAdmin, String passwordHash) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.addressId = addressId;
        this.isAdmin = isAdmin;
        this.passwordHash = passwordHash;
    }
    public User() {}

    public boolean matchPassword(String password){
        return this.passwordHash.equals(password);
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getName() {
        return name;
    }
    public int getAddressId() {
        return addressId;
    }
    public int getIsAdmin() {
        return isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }
}
