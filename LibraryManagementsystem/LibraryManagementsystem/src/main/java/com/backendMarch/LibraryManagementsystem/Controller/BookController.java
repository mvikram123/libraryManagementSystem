package com.backendMarch.LibraryManagementsystem.Controller;

import com.backendMarch.LibraryManagementsystem.Entity.Book;
import com.backendMarch.LibraryManagementsystem.Service.AuthorService;
import com.backendMarch.LibraryManagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage()+"book is not added");
        }
        return "book is added successfully";
    }

}
