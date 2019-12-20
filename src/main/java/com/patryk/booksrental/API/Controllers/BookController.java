package com.patryk.booksrental.API.Controllers;


import com.patryk.booksrental.API.Assemblers.BookResourceAssembler;
import com.patryk.booksrental.API.Resources.BookResource;
import com.patryk.booksrental.Models.Book;
import com.patryk.booksrental.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/name", produces = "application/json", method = RequestMethod.GET)
    public List<BookResource> getBookListByName(@RequestParam(required = true) String name ){
        List<Book> bookList = bookService.getListWithNames(name);
        return bookResourceAssembler.buildResources(bookList);
    }

    @RequestMapping(value = "/{someID}", produces = "application/json", method = RequestMethod.GET)
    public BookResource getBookById(@PathVariable(value = "someID") long id){
        Book book = bookService.getBookById(id);
        return bookResourceAssembler.buildResource(book);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addBook(@RequestBody Book book, @RequestParam long author_id,
                                          @RequestParam long publishing_house_id, @RequestParam long rental_id){
        bookService.addBook(bookResourceAssembler.buildBookToAdd(book, author_id, publishing_house_id, rental_id));
        return new ResponseEntity<>("Dodano", HttpStatus.OK);
    }

    @RequestMapping(value = "/updateLoan", method = RequestMethod.PUT)
    public ResponseEntity<String> updateLoan(@RequestParam(required = true)long id,
                                             @RequestParam(required = true)boolean is_loan){
        bookService.updateBookLoan(id, is_loan);
        return new ResponseEntity<>("Pomyślnie zaktualizowano status wypożyczenia!", HttpStatus.OK);
    }

    @Autowired
    public void setBookService(BookService bookService){this.bookService = bookService;}

    @Autowired
    public void setBookResourceAssembler(BookResourceAssembler bookResourceAssembler){
        this.bookResourceAssembler = bookResourceAssembler;
    }
}
