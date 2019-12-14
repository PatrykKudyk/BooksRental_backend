package com.patryk.booksrental.Services;

import com.patryk.booksrental.Models.PublishingHouse;

import java.util.List;

public interface PublishingHouseService {
    List<PublishingHouse> getList();
    PublishingHouse getPublishingHouseById(long id);
}
