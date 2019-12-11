package com.patryk.booksrental.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "location")
public class Location {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "zip_code")
    private String zip_code;
    @Column(name = "street")
    private String street;
    @Column(name = "building_number")
    private int building_number;
    @Column(name = "office_number")
    private String office_number;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private PublishingHouse publishing_house;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private Rental rental;
}
