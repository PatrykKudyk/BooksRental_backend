package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Book> getList() {
        return entityManager.createQuery("select b from Book b", Book.class).getResultList();
    }

    @Override
    public List<Book> getListOfAuthor(long authorId) {
        return entityManager.createQuery("select b from Book b where b.author= :authorId", Book.class)
                .setParameter("authorId", authorId).getResultList();
    }

    @Override
    public List<Book> getListOfNames(String name) {
        return entityManager.createQuery("select b from Book b where b.title= :name", Book.class)
                .setParameter("name", name).getResultList();
    }

    @Transactional
    @Override
    public void addBook(Book book) {
        entityManager.persist(book);
    }
}
