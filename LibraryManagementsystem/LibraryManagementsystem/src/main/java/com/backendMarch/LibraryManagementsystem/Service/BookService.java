package com.backendMarch.LibraryManagementsystem.Service;

import com.backendMarch.LibraryManagementsystem.Entity.Author;
import com.backendMarch.LibraryManagementsystem.Entity.Book;
import com.backendMarch.LibraryManagementsystem.Repository.AuthorRepository;
import com.backendMarch.LibraryManagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public void addBook(Book book) throws Exception {
        Author author;
        try {
            author=authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("author is not available");
        }
        List<Book> bookswritten=author.getBookList();
        bookswritten.add(book);
        authorRepository.save(author);
    }
}
