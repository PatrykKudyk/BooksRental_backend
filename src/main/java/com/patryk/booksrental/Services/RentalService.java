package com.patryk.booksrental.Services;

import com.patryk.booksrental.Models.Rental;

import java.util.List;

public interface RentalService {
    List<Rental> getList();
    Rental getRentalById(long id);
    List<Rental> getRentalByName(String name);
    void addRental(Rental rental);
}
