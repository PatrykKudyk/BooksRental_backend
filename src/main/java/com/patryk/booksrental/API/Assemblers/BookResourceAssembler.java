package com.patryk.booksrental.API.Assemblers;

import com.patryk.booksrental.API.Resources.BookResource;
import com.patryk.booksrental.Models.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookResourceAssembler {
    public List<BookResource> buildResources(List<Book> list){
        List<BookResource> bookResources = list.stream().map(book -> {
            BookResource bookResource = BookResource.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .release_year(book.getRelease_year())
                    .pages(book.getPages())
                    .is_thick_cover(book.is_thick_cover())
                    .is_loan(book.is_loan())
                    .description(book.getDescription())
                    .publishing_house_id(book.getPublishing_house_id())
                    .rental_id(book.getRental_id())
                    .author_id(book.getAuthor_id())
                    .build();
            return bookResource;
        }).collect(Collectors.toList());
        return bookResources;
    }

    public BookResource buildResource(Book book){
        BookResource bookResource = BookResource.builder()
                .id(book.getId())
                .title(book.getTitle())
                .release_year(book.getRelease_year())
                .pages(book.getPages())
                .is_thick_cover(book.is_thick_cover())
                .is_loan(book.is_loan())
                .description(book.getDescription())
                .publishing_house_id(book.getPublishing_house_id())
                .rental_id(book.getRental_id())
                .author_id(book.getAuthor_id())
                .user_id(book.getUser_id())
                .build();
        return bookResource;
    }

    public Book buildBook(BookResource bookResource){
        Book book = Book.builder()
                .title(bookResource.getTitle())
                .release_year(bookResource.getRelease_year())
                .pages(bookResource.getPages())
                .is_loan(bookResource.is_loan())
                .is_thick_cover(bookResource.is_thick_cover())
                .description(bookResource.getDescription())
                .publishing_house_id(bookResource.getPublishing_house_id())
                .rental_id(bookResource.getRental_id())
                .author_id(bookResource.getAuthor_id())
                .user_id(bookResource.getUser_id())
                .build();
        return book;
    }

    public Book buildBookToAdd(Book book, long author_id, long publishing_house_id, long rental_id, Long user_id){
        Book createdBook;

        if(user_id != null){
            createdBook = Book.builder()
                    .title(book.getTitle())
                    .pages(book.getPages())
                    .release_year(book.getRelease_year())
                    .is_loan(book.is_loan())
                    .is_thick_cover(book.is_thick_cover())
                    .author_id(new Author(author_id))
                    .publishing_house_id(new PublishingHouse(publishing_house_id))
                    .rental_id(new Rental(rental_id))
                    .description(book.getDescription())
                    .user_id(new User(user_id))
                    .build();

        }else{
            createdBook = Book.builder()
                    .title(book.getTitle())
                    .pages(book.getPages())
                    .release_year(book.getRelease_year())
                    .is_loan(book.is_loan())
                    .is_thick_cover(book.is_thick_cover())
                    .author_id(new Author(author_id))
                    .publishing_house_id(new PublishingHouse(publishing_house_id))
                    .rental_id(new Rental(rental_id))
                    .description(book.getDescription())
                    .build();
        }

        return createdBook;
    }
}
