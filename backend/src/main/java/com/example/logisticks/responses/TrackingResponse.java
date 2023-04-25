package com.example.logisticks.responses;
import com.example.logisticks.models.Order;
import com.example.logisticks.models.OrderStatus;


public class TrackingResponse{
    private String sCity;
    private String sDistrict;
    private String sState;

    private String dCity;
    private String dDistrict;
    private String dState;

    private String cCity;
    private String cDistrict;
    private String cState;
    private OrderStatus.Status status;
    private int receptionOTP;
    private String agentPhoneNumber;
    private String agentName;

    public TrackingResponse(String sCity, String sDistrict, String sState, String dCity, String dDistrict, String dState, String cCity, String cDistrict, String cState, OrderStatus.Status status, int receptionOTP, String agentPhoneNumber, String agentName) {
        this.sCity = sCity;
        this.sDistrict = sDistrict;
        this.sState = sState;
        this.dCity = dCity;
        this.dDistrict = dDistrict;
        this.dState = dState;
        this.cCity = cCity;
        this.cDistrict = cDistrict;
        this.cState = cState;
        this.status = status;
        this.receptionOTP = receptionOTP;
        this.agentPhoneNumber = agentPhoneNumber;
        this.agentName = agentName;
    }

    public TrackingResponse() {
    }

    @Override
    public String toString() {
        return "TrackingResponse{" +
                "sCity='" + sCity + '\'' +
                ", sDistrict='" + sDistrict + '\'' +
                ", sState='" + sState + '\'' +
                ", dCity='" + dCity + '\'' +
                ", dDistrict='" + dDistrict + '\'' +
                ", dState='" + dState + '\'' +
                ", cCity='" + cCity + '\'' +
                ", cDistrict='" + cDistrict + '\'' +
                ", cState='" + cState + '\'' +
                ", status=" + status +
                ", receptionOTP=" + receptionOTP +
                ", agentPhoneNumber='" + agentPhoneNumber + '\'' +
                ", agentName='" + agentName + '\'' +
                '}';
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsDistrict() {
        return sDistrict;
    }

    public void setsDistrict(String sDistrict) {
        this.sDistrict = sDistrict;
    }

    public String getsState() {
        return sState;
    }

    public void setsState(String sState) {
        this.sState = sState;
    }

    public String getdCity() {
        return dCity;
    }

    public void setdCity(String dCity) {
        this.dCity = dCity;
    }

    public String getdDistrict() {
        return dDistrict;
    }

    public void setdDistrict(String dDistrict) {
        this.dDistrict = dDistrict;
    }

    public String getdState() {
        return dState;
    }

    public void setdState(String dState) {
        this.dState = dState;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict;
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState;
    }

    public OrderStatus.Status getStatus() {
        return status;
    }

    public void setStatus(OrderStatus.Status status) {
        this.status = status;
    }

    public int getReceptionOTP() {
        return receptionOTP;
    }

    public void setReceptionOTP(int receptionOTP) {
        this.receptionOTP = receptionOTP;
    }

    public String getAgentPhoneNumber() {
        return agentPhoneNumber;
    }

    public void setAgentPhoneNumber(String agentPhoneNumber) {
        this.agentPhoneNumber = agentPhoneNumber;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }
}
