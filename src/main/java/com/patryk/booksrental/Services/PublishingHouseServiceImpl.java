package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.PublishingHouseDao;
import com.patryk.booksrental.Models.PublishingHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublishingHouseServiceImpl implements PublishingHouseService {

    private PublishingHouseDao publishingHouseDao;

    @Override
    public PublishingHouse getPublishingHouseById(long id) {
        return publishingHouseDao.getPublishingHouseById(id);
    }

    @Override
    public List<PublishingHouse> getList() {
        return publishingHouseDao.getList();
    }

    @Autowired
    public void setPublishingHouseDao(PublishingHouseDao publishingHouseDao){this.publishingHouseDao = publishingHouseDao;}
}
