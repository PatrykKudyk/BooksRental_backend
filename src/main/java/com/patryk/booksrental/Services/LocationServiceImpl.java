package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.LocationDao;
import com.patryk.booksrental.Models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private LocationDao locationDao;

    @Override
    public List<Location> getList() {
        return locationDao.getList();
    }

    @Override
    public Location getLocationById(long id) {
        return locationDao.getListById(id);
    }

    @Override
    public void updateUsage(long id, boolean is_used) {
        locationDao.updateUsage(id, is_used);
    }

    @Override
    public void updateLocation(long id, Location location) {
        Location locationEntity = locationDao.getListById(id);
        locationEntity.setBuilding_number(location.getBuilding_number());
        locationEntity.set_used(location.is_used());
        locationEntity.setCity(location.getCity());
        locationEntity.setOffice_number(location.getOffice_number());
        locationEntity.setState(location.getState());
        locationEntity.setStreet(location.getStreet());
        locationEntity.setZip_code(location.getZip_code());
        locationDao.updateLocation(id, locationEntity);
    }

    @Autowired
    public void setLocationDao(LocationDao locationDao){this.locationDao = locationDao;}
}
