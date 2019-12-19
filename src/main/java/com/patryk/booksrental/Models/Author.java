package com.patryk.booksrental.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
public class Author {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;


    @JsonIgnore
    @OneToMany(mappedBy = "author_id")
    private List<Book> books;

    Author(long id){
        this.id = id;
    }


//    @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
//    private Book book;

//    Author(int id){
//        this.id = id;
//    }
}
