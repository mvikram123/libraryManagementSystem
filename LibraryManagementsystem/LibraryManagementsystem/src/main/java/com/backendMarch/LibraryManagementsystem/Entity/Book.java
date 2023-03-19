package com.backendMarch.LibraryManagementsystem.Entity;

import com.backendMarch.LibraryManagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private boolean isIssued;
    @ManyToOne
    @JoinColumn
    Author author;
//    @ManyToOne
//    @JoinColumn
//    LibraryCard libraryCard;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;

}
