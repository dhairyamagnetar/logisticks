package com.example.logisticks.models;

import org.springframework.stereotype.Repository;

@Repository
public class Rate {
    private int fromLocationId;
    private int toLocationId;
    private float baseRate;

    public Rate(int fromLocationId, int toLocationId, float baseRate) {
        this.fromLocationId = fromLocationId;
        this.toLocationId = toLocationId;
        this.baseRate = baseRate;
    }
    public Rate(){}

    public int getFromLocationId() {
        return fromLocationId;
    }

    public int getToLocationId() {
        return toLocationId;
    }

    public float getBaseRate() {
        return baseRate;
    }

    public void setFromLocationId(int fromLocationId) {
        this.fromLocationId = fromLocationId;
    }

    public void setToLocationId(int toLocationId) {
        this.toLocationId = toLocationId;
    }

    public void setBaseRate(float baseRate) {
        this.baseRate = baseRate;
    }
}
