package com.patryk.booksrental.DAO;

import com.patryk.booksrental.Models.Book;

import java.util.List;

public interface BookDao {
    List<Book> getList();
    List<Book> getListOfAuthor(long authorId);
    List<Book> getListOfNames(String name);
    Book getBookById(long id);
    void addBook(Book book);
    void updateBookLoan(long id, boolean is_loan);
    void deleteBook(long id);
}
