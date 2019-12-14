package com.patryk.booksrental.Services;


import com.patryk.booksrental.DAO.BookDao;
import com.patryk.booksrental.Models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;

    @Override
    public List<Book> getList() {
        return bookDao.getList();
    }

//    @Override
//    public List<Book> getBookListOfAuthor(long authorId) {
//        return bookDao.getListOfAuthor(authorId);
//    }

    @Autowired
    public void setBookDao(BookDao bookDao){this.bookDao = bookDao;}
}