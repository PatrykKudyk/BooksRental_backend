package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Author> getList() {
        return entityManager.createQuery("select a from Author a", Author.class).getResultList();
    }

    @Override
    public Author getAuthorById(long id) {
        return entityManager.createQuery("select a from Author a where a.id = :authorId", Author.class)
                .setParameter("authorId", id).getSingleResult();
    }

    @Transactional
    @Override
    public void addAuthor(Author author) {
        entityManager.persist(author);
    }
}
