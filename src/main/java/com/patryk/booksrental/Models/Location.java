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
@Table(name = "locations")
public class Location {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "zipCode")
    private String zipCode;
    @Column(name = "street")
    private String street;
    @Column(name = "buildingNumber")
    private int buildingNumber;
    @Column(name = "officeNumber")
    private String officeNumber;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private PublishingHouse publishingHouse;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private Rental rental;
}
