package com.patryk.booksrental.Services;

import com.patryk.booksrental.Models.Location;

import java.util.List;

public interface LocationService {
    List<Location> getList();
    Location getLocationById(long id);
    void updateUsage(long id, boolean is_used);
}
