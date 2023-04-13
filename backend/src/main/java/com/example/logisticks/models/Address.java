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
    public Address(int id, String houseNumber, String locality, int locationId) {
        this.id = id;
        this.houseNumber = houseNumber;
        this.locality = locality;
        this.locationId = locationId;
    }

    public Address(){}

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

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
