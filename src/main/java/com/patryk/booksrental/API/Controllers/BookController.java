package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.BookResourceAssembler;
import com.patryk.booksrental.API.Resources.BookResource;
import com.patryk.booksrental.Models.Book;
import com.patryk.booksrental.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private BookResourceAssembler bookResourceAssembler;

    @RequestMapping(value = "/", produces = "application/json", method = RequestMethod.GET)
    public List<BookResource> getBooksList(){
        List<Book> bookList = bookService.getList();
        return bookResourceAssembler.buildResources(bookList);
    }

    @Autowired
    public void setBookService(BookService bookService){this.bookService = bookService;}

    @Autowired
    public void setBookResourceAssembler(BookResourceAssembler bookResourceAssembler){
        this.bookResourceAssembler = bookResourceAssembler;
    }
}
