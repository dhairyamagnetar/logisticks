package com.example.logisticks.dao;
import com.example.logisticks.models.SentBy;
public interface SentByDAO {
    int save(SentBy sentby);
    int update(SentBy sentby, int id);
}
