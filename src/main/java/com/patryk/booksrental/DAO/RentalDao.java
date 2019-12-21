package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Rental;

import java.util.List;

public interface RentalDao {
    List<Rental> getList();
    Rental getRentalById(long id);
    Rental getRentalByName()
}
