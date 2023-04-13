package com.example.logisticks.dao;
import com.example.logisticks.models.Address;
public interface AddressDAO {
    int save(Address address) throws Exception;
    int update(Address address, int id);
}
