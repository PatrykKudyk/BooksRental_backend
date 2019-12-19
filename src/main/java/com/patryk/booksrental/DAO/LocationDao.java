package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Location;

import java.util.List;

public interface LocationDao {
    List<Location> getList();
    Location getListById(long id);
    void updateUsage(long id, boolean is_used);
}
