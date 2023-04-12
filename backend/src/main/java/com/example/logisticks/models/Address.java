package com.example.logisticks.models;

public class Address {
    private int id;
    private String houseNumber;
    private String locality;
    private int locationId;

    public Address(String houseNumber, String locality, int locationId) {
        this.houseNumber = houseNumber;
        this.locality = locality;
        this.locationId = locationId;
    }
    public Address(){}

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getHouseNumber() {
        return houseNumber;
    }
    public String getLocality() {
        return locality;
    }
    public int getLocationId() {
        return locationId;
    }
    public void updateAddress(String houseNumber, String locality, int locationId){
        this.houseNumber = houseNumber;
        this.locality = locality;
        this.locationId = locationId;
    }
}
