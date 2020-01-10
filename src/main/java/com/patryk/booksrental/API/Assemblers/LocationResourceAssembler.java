package com.patryk.booksrental.API.Assemblers;

import com.patryk.booksrental.API.Resources.LocationResource;
import com.patryk.booksrental.Models.Location;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LocationResourceAssembler {
    public List<LocationResource> buildResources(List<Location> list){
        List<LocationResource> locationResourceList = list.stream().map(location -> {
            LocationResource locationResource = LocationResource.builder()
                    .id(location.getId())
                    .state(location.getState())
                    .city(location.getCity())
                    .zip_code(location.getZip_code())
                    .street(location.getStreet())
                    .building_number(location.getBuilding_number())
                    .office_number(location.getOffice_number())
                    .is_used(location.is_used())
                    .publishing_house_id(location.getPublishing_house())
                    .rental_id(location.getRental())
                    .build();
            return locationResource;
        }).collect(Collectors.toList());
        return locationResourceList;
    }

    public LocationResource buildResource(Location location){
        LocationResource locationResource = LocationResource.builder()
                .id(location.getId())
                .state(location.getState())
                .city(location.getCity())
                .zip_code(location.getZip_code())
                .street(location.getStreet())
                .building_number(location.getBuilding_number())
                .office_number(location.getOffice_number())
                .is_used(location.is_used())
                .publishing_house_id(location.getPublishing_house())
                .rental_id(location.getRental())
                .build();
        return locationResource;
    }
}
