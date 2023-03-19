package com.backendMarch.LibraryManagementsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class IssueBookRequestDto {
    private int libraryCardId;
    private int bookId;
       // private String bookName;


}
