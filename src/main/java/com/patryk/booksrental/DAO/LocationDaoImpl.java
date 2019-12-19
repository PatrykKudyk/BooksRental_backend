package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Location;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class LocationDaoImpl implements LocationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Location> getList() {
        return entityManager.createQuery("select l from Location l", Location.class).getResultList();
    }

    @Override
    public Location getListById(long id) {
        return entityManager.createQuery("select l from Location l where l.id= :id", Location.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public void updateUsage(long id, boolean is_used) {
        Location locationEntity = entityManager.find(Location.class, id);
        locationEntity.set_used(is_used);
    }
}
