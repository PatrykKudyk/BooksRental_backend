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
@Table(name = "user")
public class User {
    @Column(name = "id")
    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "user_type")
    private UserType user_type;


    @JsonIgnore
    @OneToMany(mappedBy = "user_id")
    private List<Book> books;

//    @OneToOne(mappedBy = "rental_id", cascade = CascadeType.ALL)
//    private Book book;

    public User(long id){
        this.id = id;
    }
}
