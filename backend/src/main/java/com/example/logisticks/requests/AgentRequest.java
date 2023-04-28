package com.example.logisticks.requests;

import java.time.LocalDateTime;

public class AgentRequest {
    private int id;
    private int OTP;

    public int getId() {
        return id;
    }

    public int getOTP() {
        return OTP;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOTP(int OTP) {
        this.OTP = OTP;
    }
}
