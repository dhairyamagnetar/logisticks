package com.example.logisticks.controllers;

import com.example.logisticks.dao.UserDAO;
import com.example.logisticks.models.SignInRequest;
import com.example.logisticks.models.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserDAO uDAO;

    @PostMapping("/auth/signup")
    public boolean signUp(@RequestBody SignUpRequest req){
        return uDAO.signUp(req.getPhoneNumber(), req.getPassword(), req.getName(), req.getHouseNumber(), req.getLocality(), req.getLocationId());
    }

    @PostMapping("/auth/signin")
    public boolean signIn(@RequestBody SignInRequest req){
        return uDAO.signIn(req.getPhoneNumber(), req.getPassword());
    }
}
