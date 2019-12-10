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
@Table(name = "publishingHouses")
public class PublishingHouse {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @MapsId
    private Location location;

    @OneToOne(mappedBy = "publishingHouse", cascade = CascadeType.ALL)
    private Book book;
}
