package com.patryk.booksrental.Services;

import com.patryk.booksrental.DAO.AuthorDao;
import com.patryk.booksrental.Models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao;

    @Override
    public Author getAuthorById(long id) {
        return authorDao.getAuthorById(id);
    }

    @Override
    public List<Author> getAuthorList() {
        return authorDao.getList();
    }

    @Override
    public void addAuthor(Author author) {
        authorDao.addAuthor(author);
    }

    @Autowired
    public void setAuthorDao(AuthorDao authorDao){this.authorDao = authorDao;}
}
