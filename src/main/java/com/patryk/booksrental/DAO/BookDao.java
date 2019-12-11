package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Book;

import java.util.List;

public interface BookDao {
    List<Book> getList();
    List<Book> getListOfAuthor(long authorId);
}
