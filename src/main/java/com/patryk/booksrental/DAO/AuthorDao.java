package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Author;

import java.util.List;

public interface AuthorDao {
    List<Author> getList();
    Author getAuthorById(long id);
    List<Author> getAuthorsByName(String name);
    void addAuthor(Author author);
}
