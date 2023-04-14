package com.example.logisticks.controllers;

import com.example.logisticks.dao.UserDAO;
import com.example.logisticks.requests.SignInRequest;
import com.example.logisticks.requests.SignUpRequest;
import com.example.logisticks.responses.SignInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserDAO uDAO;

    @PostMapping("/auth/signup")
    public SignInResponse signUp(@RequestBody SignUpRequest req){
        SignInResponse res = new SignInResponse();
        int key = uDAO.signUp(req.getPhoneNumber(), req.getPassword(), req.getName(), req.getHouseNumber(), req.getLocality(), req.getLocationId());
        res.setKey(key);
        res.setLogin(false);
        if(key > 0){
            res.setLogin(true);
        }
        return res;
    }

    @PostMapping("/auth/signin")
    public SignInResponse signIn(@RequestBody SignInRequest req){
        SignInResponse res = new SignInResponse();
        int key =  uDAO.signIn(req.getPhoneNumber(), req.getPassword());
        res.setKey(key);
        res.setLogin(false);
        if(key > 0){
            res.setLogin(true);
        }
        return res;
    }
}
