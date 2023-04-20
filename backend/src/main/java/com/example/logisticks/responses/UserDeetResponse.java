package com.example.logisticks.responses;

public class UserDeetResponse {
    private boolean status;
    private String phoneNumber;
    private int locationId;

    public UserDeetResponse(boolean status, String phoneNumber, int locationId) {
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.locationId = locationId;
    }

    public UserDeetResponse(){}

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
