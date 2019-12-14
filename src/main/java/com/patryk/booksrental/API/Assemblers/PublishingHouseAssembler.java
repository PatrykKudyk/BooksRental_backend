package com.patryk.booksrental.API.Assemblers;


import com.patryk.booksrental.API.Resources.PublishingHouseResource;
import com.patryk.booksrental.Models.PublishingHouse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublishingHouseAssembler {
    public List<PublishingHouseResource> buildResources(List<PublishingHouse> list){
        List<PublishingHouseResource> publishingHouseResources = list.stream().map(publishingHouse -> {
            PublishingHouseResource publishingHouseResource = PublishingHouseResource.builder()
                    .id(publishingHouse.getId())
                    .name(publishingHouse.getName())
                    .location(publishingHouse.getLocation_id())
                    .build();
            return publishingHouseResource;
        }).collect(Collectors.toList());
        return publishingHouseResources;
    }

    public PublishingHouseResource buildResource(PublishingHouse publishingHouse){
        PublishingHouseResource publishingHouseResource = PublishingHouseResource.builder()
                .id(publishingHouse.getId())
                .name(publishingHouse.getName())
                .location(publishingHouse.getLocation_id())
                .books(publishingHouse.getBooks())
                .build();
        return publishingHouseResource;
    }
}
