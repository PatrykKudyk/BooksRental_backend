package com.patryk.booksrental.API.Assemblers;


import com.patryk.booksrental.API.Resources.AuthorResource;
import com.patryk.booksrental.Models.Author;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorResourceAssembler {
    public List<AuthorResource> buildResources(List<Author> list){
        List<AuthorResource> authorResources = list.stream().map(author -> {
            AuthorResource authorResource = AuthorResource.builder()
                    .id(author.getId())
                    .name(author.getName())
                    .lastName(author.getLastName())
                    .age(author.getAge())
//                    .book(author.getBooks())
                    .build();
            return authorResource;
        }).collect(Collectors.toList());
        return authorResources;
    }

    public AuthorResource buildResource(Author author){
        AuthorResource authorResource = AuthorResource.builder()
                .id(author.getId())
                .name(author.getName())
                .lastName(author.getLastName())
                .age(author.getAge())
                .books(author.getBooks())
                .build();
        return authorResource;
    }
}
