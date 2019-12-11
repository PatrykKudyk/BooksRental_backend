package com.patryk.booksrental.API.Assemblers;

import com.patryk.booksrental.API.Resources.BookResource;
import com.patryk.booksrental.Models.Book;
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
//                    .publishing_house(book.getPublishing_house())
//                    .rental(book.getRental())
                    .author(book.getAuthor_id())
                    .build();
            return bookResource;
        }).collect(Collectors.toList());
        return bookResources;
    }

    public List<BookResource> buildResourcesOfAuthor(List<BookResource> list, long authorId){
        List<BookResource> bookResources = null;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAuthor().getId() == authorId){
               bookResources.add(list.get(i));
            }
        }
        return bookResources;
    }
}
