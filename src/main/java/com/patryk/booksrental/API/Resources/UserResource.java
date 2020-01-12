package com.patryk.booksrental.API.Resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.patryk.booksrental.Models.Book;
import com.patryk.booksrental.Models.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserResource {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String last_name;
    @JsonProperty
    private String email;
    @JsonProperty
    private String login;
    @JsonProperty
    private String password;
    @JsonProperty
    private UserType user_type;
    @JsonProperty
    private List<Book> books;
}
