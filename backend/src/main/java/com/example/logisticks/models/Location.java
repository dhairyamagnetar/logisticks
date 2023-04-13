package com.example.logisticks.models;

public class Location {
    private int id;
    private String district;
    private String city;
    private String state;

    public Location(int id, String district, String city, String state) {
        this.id = id;
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public Location(String district, String city, String state) {
        this.district = district;
        this.city = city;
        this.state = state;
    }

    public Location(){}

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }
    public String getDistrict() {
        return district;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void updateLocation(String district, String city, String state){
        this.district = district;
        this.city = city;
        this.state = state;
    }
}
