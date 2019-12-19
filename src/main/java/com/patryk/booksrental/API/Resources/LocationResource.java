package com.patryk.booksrental.API.Resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.patryk.booksrental.Models.PublishingHouse;
import com.patryk.booksrental.Models.Rental;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Builder
@AllArgsConstructor
public class LocationResource {
    @JsonProperty
    private long id;
    @JsonProperty
    private String state;
    @JsonProperty
    private String city;
    @JsonProperty
    private String zip_code;
    @JsonProperty
    private String street;
    @JsonProperty
    private String building_number;
    @JsonProperty
    private String office_number;
    @JsonProperty
    private boolean is_used;
    @JsonProperty
    private PublishingHouse publishingHouse;
    @JsonProperty
    private Rental rental;
}
