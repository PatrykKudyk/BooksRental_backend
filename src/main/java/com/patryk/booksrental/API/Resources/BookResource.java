package com.patryk.booksrental.API.Resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.patryk.booksrental.Models.Author;
import com.patryk.booksrental.Models.Rental;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookResource {
    @JsonProperty
    private long id;
    @JsonProperty
    private String title;
    @JsonProperty
    private int release_year;
    @JsonProperty
    private int pages;
    @JsonProperty
    private boolean is_thick_cover;
    @JsonProperty
    private boolean is_loan;
    @JsonProperty
    private Rental rental;
    @JsonProperty
    private Author author;

}
