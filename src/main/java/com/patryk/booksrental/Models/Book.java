package com.patryk.booksrental.Models;


import com.fasterxml.jackson.annotation.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @Column(name = "title")
    private String title;

//    @OneToOne
//    @MapsId("rental_id")
//    private Rental rental_id;


    @Column(name = "release_year")
    private int release_year;
    @Column(name = "pages")
    private int pages;
    @Column(name = "is_thick_cover")
    private boolean is_thick_cover;
    @Column(name = "is_loan")
    private boolean is_loan;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "rental_id", nullable = false)
    private Rental rental_id;

    @JsonIgnore
    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "publishing_house_id", nullable = false)
    private PublishingHouse publishing_house_id;

//    @JsonIgnore
//    @JsonIgnoreProperties
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

//    Book(String title, int release_year, int pages, boolean is_thick_cover, boolean is_loan, long rental_id,
//         long publishing_house_id, long author_id){
//        this.title = title;
//        this.release_year = release_year;
//        this.pages = pages;
//        this.is_thick_cover = is_thick_cover;
//        this.is_loan = is_loan;
//        this.rental_id = new Rental(rental_id);
//        this.publishing_house_id = new PublishingHouse(publishing_house_id);
//        this.author_id = new Author(author_id);
//    }

}
