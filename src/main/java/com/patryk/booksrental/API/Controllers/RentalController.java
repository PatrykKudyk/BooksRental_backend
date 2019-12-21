package com.patryk.booksrental.API.Controllers;

import com.patryk.booksrental.API.Assemblers.RentalResourceAssembler;
import com.patryk.booksrental.API.Resources.RentalResource;
import com.patryk.booksrental.Models.Rental;
import com.patryk.booksrental.Services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rental")
public class RentalController {
    private RentalService rentalService;
    private RentalResourceAssembler rentalResourceAssembler;

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<RentalResource> getList(){
        List<Rental> rentalList = rentalService.getList();
        return rentalResourceAssembler.buildResources(rentalList);
    }

    @RequestMapping(value = "/{someID}", produces = "application/json", method = RequestMethod.GET)
    public RentalResource getRentalById(@PathVariable(value = "someID") long id){
        Rental rental = rentalService.getRentalById(id);
        return rentalResourceAssembler.buildResource(rental);
    }

    @RequestMapping(value = "/name", produces = "application/json", method = RequestMethod.GET)
    public List<RentalResource> getRentalsByName(@RequestParam(required = true) String name){
        List<Rental> rentalList = rentalService.getRentalByName(name);
        return rentalResourceAssembler.buildResources(rentalList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addRental(@RequestBody(required = true) Rental rental){
        rentalService.addRental(rental);
        return new ResponseEntity<>("Pomyślnie dodano wypożyczalnię!", HttpStatus.OK);
    }
    
    @Autowired
    public void setRentalService(RentalService rentalService){this.rentalService = rentalService;}

    @Autowired
    public void setRentalResourceAssembler(RentalResourceAssembler rentalResourceAssembler){
        this.rentalResourceAssembler = rentalResourceAssembler;
    }
}
