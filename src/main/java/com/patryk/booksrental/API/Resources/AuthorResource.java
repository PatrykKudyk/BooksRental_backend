package com.patryk.booksrental.API.Resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.patryk.booksrental.Models.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthorResource {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private int age;
    @JsonProperty
    private Book book;
}
