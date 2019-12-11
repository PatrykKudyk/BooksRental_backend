package com.patryk.booksrental.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "book")
public class Book {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "title")
    private String title;

//    @OneToOne
//    @MapsId("author_id")
//    private Author author;


    @Column(name = "release_year")
    private int release_year;
    @Column(name = "pages")
    private int pages;
    @Column(name = "is_thick_cover")
    private boolean is_thick_cover;


//    @OneToOne
//    @MapsId("publishing_house_id")
//    private PublishingHouse publishing_house;

    @Column(name = "is_loan")
    private boolean is_loan;

//    @ManyToOne
//    @JoinColumn(name = "rental_id", nullable = false)
//    private Rental rental;

    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    @JsonIgnore
    private Author author_id;

}
