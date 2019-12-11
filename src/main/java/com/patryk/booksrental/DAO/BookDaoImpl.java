package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return entityManager.createQuery("select b from Book b where b.author_id =:author_id", Book.class)
                .setParameter("author_id", authorId).getResultList();
    }
}
