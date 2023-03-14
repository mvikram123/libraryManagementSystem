package com.backendMarch.LibraryManagementsystem.Entity;

import com.backendMarch.LibraryManagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String title;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    @JoinColumn
    Author author;


}
