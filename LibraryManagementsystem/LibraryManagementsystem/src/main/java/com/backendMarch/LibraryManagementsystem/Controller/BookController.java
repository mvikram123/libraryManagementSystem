package com.backendMarch.LibraryManagementsystem.Controller;

import com.backendMarch.LibraryManagementsystem.DTO.BookRequestDto;
import com.backendMarch.LibraryManagementsystem.DTO.BookResponseDto;
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
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {

       return bookService.addBook(bookRequestDto);
    }

}
