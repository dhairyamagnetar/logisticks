package com.example.logisticks.dao;
import java.util.List;
import com.example.logisticks.models.Location;

public interface LocationDAO {
    int save(Location location);
    List<Location> fetchAll();
}
