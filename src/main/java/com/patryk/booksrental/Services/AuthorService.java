package com.patryk.booksrental.Services;

import com.patryk.booksrental.Models.Author;

import java.util.List;

public interface AuthorService {
    Author getAuthorById(long id);
    List<Author> getAuthorList();
    List<Author> getAuthorsByName(String name);
    void addAuthor(Author author);
}
