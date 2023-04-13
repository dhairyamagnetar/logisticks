package com.example.logisticks.models;

public class User {
    private String phoneNumber;
    private String name;
    private int addressId;
    private int isAdmin;
    private String passwordHash;

    public String getPasswordHash() {
        return passwordHash;
    }

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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                ", isAdmin=" + isAdmin +
                ", passwordHash='" + passwordHash + '\'' +
                '}';
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
