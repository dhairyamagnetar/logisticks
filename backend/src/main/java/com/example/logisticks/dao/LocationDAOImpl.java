package com.example.logisticks.dao;
import com.example.logisticks.models.Course;
import com.example.logisticks.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAOImpl implements LocationDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int save(Location location) {
        return jdbcTemplate.update("INSERT INTO location(city, district, state) values(?, ? , ? )", location.getCity(), location.getDistrict(), location.getState());
    }
    @Override
    public List<Location> fetchAll() {
        return jdbcTemplate.query("select * from location", new BeanPropertyRowMapper<Location>(Location.class));
    }
}
