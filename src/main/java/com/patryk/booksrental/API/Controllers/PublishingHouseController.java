package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.PublishingHouseAssembler;
import com.patryk.booksrental.API.Resources.PublishingHouseResource;
import com.patryk.booksrental.Models.PublishingHouse;
import com.patryk.booksrental.Services.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishingHouse")
public class PublishingHouseController {
    private PublishingHouseAssembler publishingHouseAssembler;
    private PublishingHouseService publishingHouseService;

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<PublishingHouseResource> getList(){
        List<PublishingHouse> publishingHouseList = publishingHouseService.getList();
        return publishingHouseAssembler.buildResources(publishingHouseList);
    }

    @RequestMapping(value = "/{someID}", produces = "application/json", method = RequestMethod.GET)
    public PublishingHouseResource getPublishingHouse(@PathVariable(value = "someID") long id){
        PublishingHouse publishingHouse = publishingHouseService.getPublishingHouseById(id);
        return publishingHouseAssembler.buildResource(publishingHouse);
    }

    @RequestMapping(value = "/name", produces = "application/json", method = RequestMethod.GET)
    public List<PublishingHouseResource> getPublishingHouseByName(@RequestParam(required = true) String name){
        List<PublishingHouse> publishingHouseList = publishingHouseService.getPublishingHouseByName(name);
        return publishingHouseAssembler.buildResources(publishingHouseList);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addPublishingHouse(@RequestBody(required = true) PublishingHouse publishingHouse){
        publishingHouseService.addPublishingHouse(publishingHouse);
        return new ResponseEntity<>("Dodano!", HttpStatus.OK);
    }

    @Autowired
    public void setPublishingHouseAssembler(PublishingHouseAssembler publishingHouseAssembler){
        this.publishingHouseAssembler = publishingHouseAssembler;
    }

    @Autowired
    public void setPublishingHouseService(PublishingHouseService publishingHouseService){
        this.publishingHouseService = publishingHouseService;
    }
}
