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
@Table(name = "books")
public class Book {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "title")
    private String title;

    @OneToOne
    @MapsId("authorId")
    private Author author;


    @Column(name = "releaseYear")
    private int releaseYear;
    @Column(name = "pages")
    private int pages;
    @Column(name = "isThickCover")
    private boolean isThickCover;


    @OneToOne
    @MapsId("publishingHouseId")
    private PublishingHouse publishingHouse;

    @Column(name = "isLoan")
    private boolean isLoan;

    @ManyToOne
    @JoinColumn(name = "rentalId", nullable = false)
    private Rental rental;

}
