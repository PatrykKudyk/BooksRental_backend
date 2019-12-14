package com.patryk.booksrental.Services;

import com.patryk.booksrental.Models.Book;

import java.util.List;

public interface BookService {
    List<Book> getList();
//    List<Book> getBookListOfAuthor(long authorId);
    List<Book> getListWithNames(String name);
}
