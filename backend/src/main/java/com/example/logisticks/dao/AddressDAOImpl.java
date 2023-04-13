package com.example.logisticks.dao;
import com.example.logisticks.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl implements AddressDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Address address) {
        return jdbcTemplate.update("insert into address(houseNumber, locality, locationId) values (?, ?, ?)", address.getHouseNumber(), address.getLocality(), address.getLocationId());
    }

    @Override
    public int update(Address address, int id) {
        return jdbcTemplate.update("update address set houseNumber = ?, locality = ?, locationId = ? where id = ?", address.getHouseNumber(), address.getLocality(), address.getLocationId(), id);
    }
}
