package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.RentalDao;
import com.patryk.booksrental.Models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentaServiceImpl implements RentalService {

    private RentalDao rentalDao;

    @Override
    public List<Rental> getList() {
        return  rentalDao.getList();
    }

    @Override
    public Rental getRentalById(long id) {
        return rentalDao.getRentalById(id);
    }

    @Override
    public List<Rental> getRentalByName(String name) {
        return rentalDao.getRentalByName(name);
    }

    @Override
    public void addRental(Rental rental) {
        rentalDao.addRental(rental);
    }

    @Autowired
    public void setRentalDao(RentalDao rentalDao){this.rentalDao = rentalDao;}
}
