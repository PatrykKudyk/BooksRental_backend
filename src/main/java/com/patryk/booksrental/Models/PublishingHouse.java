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
@Table(name = "publishing_house")
public class PublishingHouse {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @OneToOne
    @MapsId
    private Location location;

//    @OneToOne(mappedBy = "publishing_house", cascade = CascadeType.ALL)
//    private Book book;
}
