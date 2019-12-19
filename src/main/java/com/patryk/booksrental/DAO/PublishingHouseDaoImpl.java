package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.PublishingHouse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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

    @Override
    public List<PublishingHouse> getPublishingHouseByName(String name) {
        return entityManager.createQuery("select p from PublishingHouse p where p.name= :name", PublishingHouse.class)
                .setParameter("name", name).getResultList();
    }

    @Transactional
    @Override
    public void addPublishingHouse(PublishingHouse publishingHouse) {
        entityManager.persist(publishingHouse);
    }
}
