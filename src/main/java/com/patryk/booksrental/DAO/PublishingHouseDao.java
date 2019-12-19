package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.PublishingHouse;

import java.util.List;

public interface PublishingHouseDao {
    List<PublishingHouse> getList();
    PublishingHouse getPublishingHouseById(long id);
    List<PublishingHouse> getPublishingHouseByName(String name);
    void addPublishingHouse(PublishingHouse publishingHouse);
}
