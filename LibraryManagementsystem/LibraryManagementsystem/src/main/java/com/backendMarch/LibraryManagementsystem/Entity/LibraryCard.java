package com.backendMarch.LibraryManagementsystem.Entity;

import com.backendMarch.LibraryManagementsystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updationTime;
    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "libraryCard",cascade=CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();
    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    List<Book> booksIssued=new ArrayList<>();


}
