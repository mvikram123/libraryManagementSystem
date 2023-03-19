package com.backendMarch.LibraryManagementsystem.DTO;

import com.backendMarch.LibraryManagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class IssueBookResponseDto {
    private String transactionId;
    private String title;
    TransactionStatus transactionStatus;

  //  public void setBookName(String title) {
   // }
}
