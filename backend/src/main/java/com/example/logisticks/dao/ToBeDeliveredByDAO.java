package com.example.logisticks.dao;
import com.example.logisticks.models.ToBeDeliveredBy;
public interface ToBeDeliveredByDAO {
    int save(ToBeDeliveredBy deliver);
    int update(ToBeDeliveredBy deliver, int id);
}
