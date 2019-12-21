package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Rental;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RentalDaoImpl implements RentalDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Rental> getList() {
        return entityManager.createQuery("select r from Rental r", Rental.class).getResultList();
    }

    @Override
    public Rental getRentalById(long id) {
        return entityManager.createQuery("select r from Rental r where r.id= :id", Rental.class)
                .setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Rental> getRentalByName(String name) {
        return entityManager.createQuery("select r from Rental r where r.name like :name", Rental.class)
                .setParameter("name", "%" + name + "%").getResultList();
    }

    @Transactional
    @Override
    public void addRental(Rental rental) {
        entityManager.persist(rental);
    }
}
