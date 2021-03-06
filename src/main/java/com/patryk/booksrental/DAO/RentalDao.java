package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Location;
import com.patryk.booksrental.Models.Rental;

import java.util.List;

public interface RentalDao {
    List<Rental> getList();
    Rental getRentalById(long id);
    List<Rental> getRentalByName(String name);
    void addRental(Rental rental);
    void updateRentalLocation(long id, Location location);
}
