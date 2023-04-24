package com.example.logisticks.controllers;

import com.example.logisticks.dao.AgentDAO;
import com.example.logisticks.requests.SignInRequest;
import com.example.logisticks.requests.SignUpRequest;
import com.example.logisticks.responses.SignInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AgentController {
    @Autowired
    private AgentDAO aDAO;

    @PostMapping("/agent/signup")
    public SignInResponse signUp(@RequestBody SignUpRequest req){
        SignInResponse res = new SignInResponse();
        int key = aDAO.signUp(req.getPhoneNumber(), req.getPassword(), req.getName(), req.getHouseNumber(), req.getLocality(), req.getLocationId(), req.getVehicleNumber(), req.getSalary());
        res.setKey(key);
        res.setLogin(false);
        if(key > 0){
            res.setLogin(true);
        }
        return res;
    }

    @PostMapping("/agent/signin")
    public SignInResponse signIn(@RequestBody SignInRequest req){
        SignInResponse res = new SignInResponse();
        int key =  aDAO.signIn(req.getPhoneNumber(), req.getPassword());
        res.setKey(key);
        res.setLogin(false);
        if(key > 0){
            res.setLogin(true);
        }
        return res;
    }

    @getMapping("/agent/vieworder")
    public int viewAssignedOrders()
    {

    }
}
