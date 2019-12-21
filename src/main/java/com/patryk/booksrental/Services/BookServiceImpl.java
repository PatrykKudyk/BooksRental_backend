package com.patryk.booksrental.Services;


import com.patryk.booksrental.DAO.BookDao;
import com.patryk.booksrental.Models.Book;
import com.patryk.booksrental.Models.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookDao bookDao;
    private RentalService rentalService;

    @Override
    public List<Book> getList() {
        return bookDao.getList();
    }

//    @Override
//    public List<Book> getBookListOfAuthor(long authorId) {
//        return bookDao.getListOfAuthor(authorId);
//    }


    @Override
    public List<Book> getListWithNames(String name) {
        return bookDao.getListOfNames(name);
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(long id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBookLoan(long id, boolean is_loan) {
        bookDao.updateBookLoan(id, is_loan);
    }

    @Override
    public void updateBookRental(long id, long rental_id) {
        Rental rental = rentalService.getRentalById(rental_id);
        bookDao.updateRental(id, rental);
    }

    @Autowired
    public void setRentalService(RentalService rentalService){this.rentalService = rentalService;}

    @Autowired
    public void setBookDao(BookDao bookDao){this.bookDao = bookDao;}
}
