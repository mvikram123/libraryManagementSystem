package com.backendMarch.LibraryManagementsystem.Service;

import com.backendMarch.LibraryManagementsystem.DTO.BookRequestDto;
import com.backendMarch.LibraryManagementsystem.DTO.BookResponseDto;
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
    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {
        //create object for author
        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();

        //create object for book
        Book book=new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        book.setAuthor(author);
        author.getBooks().add(book);
        authorRepository.save(author);//will save book and author


        BookResponseDto bookResponseDto=new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;
    }

}
