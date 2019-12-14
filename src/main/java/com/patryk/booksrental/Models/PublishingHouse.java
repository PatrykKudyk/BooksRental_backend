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
@Table(name = "publishing_house")
public class PublishingHouse {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "name")
    private String name;


    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location_id;


    @JsonIgnore
    @OneToMany(mappedBy = "publishing_house_id")
    private List<Book> books;

}
