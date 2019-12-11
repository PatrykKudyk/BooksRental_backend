package com.patryk.booksrental.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
    @OneToMany(mappedBy = "rental")
    private Set<Book> books;
    @OneToOne
    @MapsId
    private Location location;
}
