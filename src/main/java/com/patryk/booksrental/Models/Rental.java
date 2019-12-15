package com.patryk.booksrental.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rental")
public class Rental {
    @Column(name = "id")
    @Id
    private long id;

    @JsonIgnore
    @OneToMany(mappedBy = "rental_id")
    private List<Book> books;


    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location_id;

//    @OneToOne(mappedBy = "rental_id", cascade = CascadeType.ALL)
//    private Book book;

//    Rental(int id){
//        this.id = id;
//    }
}
