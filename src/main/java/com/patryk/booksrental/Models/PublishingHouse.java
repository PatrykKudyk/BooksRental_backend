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

    public PublishingHouse(long id){
        this.id = id;
    }

//    PublishingHouse(String name, long location_id){
//        this.name = name;
//        this.location_id.setId(location_id);
//    }

}
