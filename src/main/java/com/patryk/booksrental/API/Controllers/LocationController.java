package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.LocationResourceAssembler;
import com.patryk.booksrental.API.Resources.LocationResource;
import com.patryk.booksrental.Models.Location;
import com.patryk.booksrental.Services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private LocationResourceAssembler locationResourceAssembler;
    private LocationService locationService;

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<LocationResource> getList(){
        List<Location> locationList = locationService.getList();
        return locationResourceAssembler.buildResources(locationList);
    }

    @RequestMapping(value = "/{someID}", produces = "application/json", method = RequestMethod.GET)
    public LocationResource getLocationById(@PathVariable(value = "someID") long id){
        Location location = locationService.getLocationById(id);
        return locationResourceAssembler.buildResource(location);
    }

    @RequestMapping(value = "/updateUsage", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUsage(@RequestParam(required = true)long id,
                                              @RequestParam(required = true)boolean is_used){
        locationService.updateUsage(id, is_used);
        return new ResponseEntity<>("Zmiana dokonana pomyślnie!", HttpStatus.OK);
    }


    @Autowired
    public void setLocationResourceAssembler(LocationResourceAssembler locationResourceAssembler){this.locationResourceAssembler = locationResourceAssembler;}

    @Autowired
    public void setLocationService(LocationService locationService){this.locationService = locationService;}
}
