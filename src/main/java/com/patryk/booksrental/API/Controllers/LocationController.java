package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.LocationAssembler;
import com.patryk.booksrental.API.Resources.LocationResource;
import com.patryk.booksrental.Models.Location;
import com.patryk.booksrental.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationAssembler locationAssembler;
    private LocationService locationService;

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<LocationResource> getList(){
        List<Location> locationList = locationService.getList();
        return locationAssembler.buildResources(locationList);
    }


    @Autowired
    public void setLocationAssembler(LocationAssembler locationAssembler){this.locationAssembler = locationAssembler;}

    @Autowired
    public void setLocationService(LocationService locationService){this.locationService = locationService;}
}
