package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.RentalDao;
import com.patryk.booksrental.Models.Location;
import com.patryk.booksrental.Models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentaServiceImpl implements RentalService {

    private RentalDao rentalDao;
    private LocationService locationService;

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

    @Override
    public void updateLocation(long id, long location_id) {
        Location location = locationService.getLocationById(location_id);
        rentalDao.updateRentalLocation(id, location);
    }

    @Autowired
    public void setLocationService(LocationService locationService){this.locationService = locationService;}

    @Autowired
    public void setRentalDao(RentalDao rentalDao){this.rentalDao = rentalDao;}
}
