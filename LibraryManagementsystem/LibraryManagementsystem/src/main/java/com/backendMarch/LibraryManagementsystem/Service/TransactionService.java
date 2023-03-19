package com.backendMarch.LibraryManagementsystem.Service;

import com.backendMarch.LibraryManagementsystem.DTO.IssueBookRequestDto;
import com.backendMarch.LibraryManagementsystem.DTO.IssueBookResponseDto;
import com.backendMarch.LibraryManagementsystem.Entity.Book;
import com.backendMarch.LibraryManagementsystem.Entity.LibraryCard;
import com.backendMarch.LibraryManagementsystem.Entity.Transaction;
import com.backendMarch.LibraryManagementsystem.Enum.CardStatus;
import com.backendMarch.LibraryManagementsystem.Enum.TransactionStatus;
import com.backendMarch.LibraryManagementsystem.Repository.BookRepository;
import com.backendMarch.LibraryManagementsystem.Repository.LibraryCardRepository;
import com.backendMarch.LibraryManagementsystem.Repository.TransactionRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter

@Service
public class TransactionService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;
    @Autowired
    TransactionRepository transactionRepository;
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);


        LibraryCard libraryCard;
        try {
            libraryCard = libraryCardRepository.findById(issueBookRequestDto.getLibraryCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMessage("Sorry ! Book is already issued");
            throw new Exception("invalid card");
        }

        Book book;

        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("Invalid bookId");
            transactionRepository.save(transaction);

            throw new Exception("bookId is invalid");
        }
        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);
        // both book and card id

        if (libraryCard.getCardStatus() != CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);

            transaction.setMessage("your card is not activated");
            transactionRepository.save(transaction);

            throw new Exception("Your card is not activated");
        }


        if(!book.isIssued())
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMessage("your card is successfully activated");

            throw new Exception("Your card is  activated");

        }
       // public List<TransactionResponseDto>
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("transaction was successful");

        book.setIssued(true);
        book.setLibraryCard(libraryCard);
        book.getTransactions().add(transaction);
        libraryCard.getTransactionList().add(transaction);
        libraryCard.getBooksIssued().add(book);

        libraryCardRepository.save(libraryCard);//will save card and transaction also

        IssueBookResponseDto issueBookResponseDto =new IssueBookResponseDto();
        issueBookResponseDto.setTransactionId(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setTitle(book.getTitle());

        return issueBookResponseDto;
    }
}
