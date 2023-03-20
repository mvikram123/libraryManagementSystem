package com.backendMarch.LibraryManagementsystem.DTO;

import com.backendMarch.LibraryManagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDto {

    private String title;
    private int price;


    private Genre genre;
    private int authorId;

}
