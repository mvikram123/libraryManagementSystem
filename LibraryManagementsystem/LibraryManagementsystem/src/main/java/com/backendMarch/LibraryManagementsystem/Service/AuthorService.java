package com.backendMarch.LibraryManagementsystem.Service;

import com.backendMarch.LibraryManagementsystem.Entity.Author;
import com.backendMarch.LibraryManagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author)
    {
        authorRepository.save(author);
        return "author has been added successfully";
    }
}
