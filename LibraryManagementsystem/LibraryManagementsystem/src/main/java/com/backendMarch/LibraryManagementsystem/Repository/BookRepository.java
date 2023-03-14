package com.backendMarch.LibraryManagementsystem.Repository;

import com.backendMarch.LibraryManagementsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
