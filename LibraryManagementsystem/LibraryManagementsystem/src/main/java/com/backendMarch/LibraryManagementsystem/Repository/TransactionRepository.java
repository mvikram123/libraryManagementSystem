package com.backendMarch.LibraryManagementsystem.Repository;

import com.backendMarch.LibraryManagementsystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    //List<Transaction> getAllSuccessfullTxnsWithCardNo(int libraryCardId);
}
