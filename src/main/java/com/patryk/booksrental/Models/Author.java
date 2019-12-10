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
@Table(name = "authors")
public class Author {
    @Column(name = "id")
    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "authors", cascade = CascadeType.ALL)
    private Book book;
}
