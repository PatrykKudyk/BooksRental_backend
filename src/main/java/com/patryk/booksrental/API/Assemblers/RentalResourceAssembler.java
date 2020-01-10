package com.patryk.booksrental.API.Assemblers;


import com.patryk.booksrental.API.Resources.RentalResource;
import com.patryk.booksrental.Models.Rental;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RentalResourceAssembler {

    public List<RentalResource> buildResources(List<Rental> list){

        List<RentalResource> rentalResourceList = list.stream().map(rental -> {
            RentalResource rentalResource = RentalResource.builder()
                    .id(rental.getId())
                    .name(rental.getName())
                    .location_id(rental.getLocation_id())
                    .build();
            return rentalResource;
        }).collect(Collectors.toList());

        return rentalResourceList;
    }

    public RentalResource buildResource(Rental rental){
        RentalResource rentalResource = RentalResource.builder()
                .id(rental.getId())
                .name(rental.getName())
                .location_id(rental.getLocation_id())
                .books(rental.getBooks())
                .build();
        return rentalResource;
    }
}
