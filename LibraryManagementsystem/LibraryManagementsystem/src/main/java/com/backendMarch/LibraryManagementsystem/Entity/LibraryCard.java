package com.backendMarch.LibraryManagementsystem.Entity;

import com.backendMarch.LibraryManagementsystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor//do not need to write default contructor
@AllArgsConstructor//do not need to write parameterised constructor
@Getter//do not need to write getter methods

@Setter//do not need to write setter methods


public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
    private String validTill;
    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;
    @OneToOne
    @JoinColumn
    Student student;

}
