package com.backendMarch.LibraryManagementsystem.Repository;

import com.backendMarch.LibraryManagementsystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard,Integer> {
}
