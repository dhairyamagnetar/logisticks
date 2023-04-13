package com.example.logisticks.dao;
import com.example.logisticks.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class AddressDAOImpl implements AddressDAO{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Address address) throws Exception{
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        String sql = "insert into address(houseNumber, locality, locationId) values (?, ?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, address.getHouseNumber());
            stmt.setString(2, address.getLocality());
            stmt.setInt(3, address.getLocationId());
            return stmt;
        }, generatedKeyHolder);
        return generatedKeyHolder.getKey().intValue();
    }

    @Override
    public int update(Address address, int id) {
        return jdbcTemplate.update("update address set houseNumber = ?, locality = ?, locationId = ? where id = ?", address.getHouseNumber(), address.getLocality(), address.getLocationId(), id);
    }
}
