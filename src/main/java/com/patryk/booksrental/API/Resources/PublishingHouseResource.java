package com.patryk.booksrental.API.Resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.patryk.booksrental.Models.Book;
import com.patryk.booksrental.Models.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class PublishingHouseResource {
    @JsonProperty
    private long id;
    @JsonProperty
    private String name;
    @JsonProperty
    private Location location;
    @JsonProperty
    private List<Book> books;
}
