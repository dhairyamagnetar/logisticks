package com.example.logisticks.controllers;
import com.example.logisticks.dao.LocationDAO;
import com.example.logisticks.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationDAO lDAO;

    @GetMapping("/location")
    public List<Location> getLocations(){
        return lDAO.fetchAll();
    }

    @PostMapping("/location")
    public String saveLocation(@RequestBody Location location){
        return lDAO.save(location) + " row(s) saved to the database.";
    }
}
