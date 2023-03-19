package com.backendMarch.LibraryManagementsystem.Entity;

import com.backendMarch.LibraryManagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transactionNumber;
    @Enumerated(EnumType.STRING)
   TransactionStatus transactionStatus;
    @CreatedDate
    private Date transactionDate;
    private String message;
    private boolean isIssueOperation;


    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard libraryCard;
}
