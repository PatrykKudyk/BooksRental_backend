package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.PublishingHouse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PublishingHouseDaoImpl implements PublishingHouseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PublishingHouse> getList() {
        return entityManager.createQuery("select p from PublishingHouse p", PublishingHouse.class).getResultList();
    }

    @Override
    public PublishingHouse getPublishingHouseById(long id) {
        return entityManager.createQuery("select p from PublishingHouse p where p.id= :id", PublishingHouse.class)
                .setParameter("id", id).getSingleResult();
    }
}
