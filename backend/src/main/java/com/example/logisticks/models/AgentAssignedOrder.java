package com.example.logisticks.models;

public class AgentAssignedOrder{
    private int id,isFragile,isExpressDelivery;
    private float weight;
    private String receiverPhoneNumber;
    private String houseNumber,locality,district,city,state,receiverAddress;


    public AgentAssignedOrder() {
    }

    public void setId(int id)
    {
        this.id=id;
    }
    public void setIsExpressDelivery(int isExpressDelivery)
    {
        this.isExpressDelivery=isExpressDelivery;
    }
    public void setIsFragile(int isFragile)
    {
        this.isFragile=isFragile;
    }
    public void setWeight(float weight)
    {
        this.weight=weight;
    }
    public void setReceiverPhoneNumber(String receiverPhoneNumber)
    {
        this.receiverPhoneNumber=receiverPhoneNumber;
    }

    public void setReceiverAddress(String receiverAddress)
    {
        this.receiverAddress=receiverAddress;
    }

    public String getReceiverAddress()
    {
        return receiverAddress;
    }
//    public void setLocality(String locality)
//    {
//        this.locality=locality;
//    }
//
//    public void setDistrict(String district)
//    {
//        this.district=district;
//    }
//
//    public void setCity(String city)
//    {
//        this.city=city;
//    }
//
//    public void setHouseNumber(String houseNumber)
//    {
//        this.houseNumber=houseNumber;
//    }
//
//    public void setState(String state)
//    {
//        this.state=state;
//    }
    public int getId()
    {
        return id;
    }
    public int getIsExpressDelivery()
    {
        return isExpressDelivery;
    }
    public int getIsFragile()
    {
        return isFragile;
    }
    public float getWeight()
    {
        return weight;
    }
    public String getReceiverPhoneNumber()
    {
        return receiverPhoneNumber;
    }

//    public String getLocality()
//    {
//        return locality;
//    }
//
//    public String getDistrict()
//    {
//        return district;
//    }
//
//    public String getCity()
//    {
//        return city;
//    }
//
//    public String getHouseNumber()
//    {
//        return houseNumber;
//    }
//
//    public String getState()
//    {
//        return state;
//    }

}
