package com.backendmarch.librarymanagementsystem.Service;

import com.backendmarch.librarymanagementsystem.DTO.IssueBookRequestDTO;
import com.backendmarch.librarymanagementsystem.DTO.IssueBookResponseDTO;
import com.backendmarch.librarymanagementsystem.DTO.ReturnBookReponseDTO;
import com.backendmarch.librarymanagementsystem.DTO.ReturnBookRequestDTO;
import com.backendmarch.librarymanagementsystem.Entity.Book;
import com.backendmarch.librarymanagementsystem.Entity.LibraryCard;
import com.backendmarch.librarymanagementsystem.Entity.Transaction;
import com.backendmarch.librarymanagementsystem.Enum.CardStatus;
import com.backendmarch.librarymanagementsystem.Enum.TransactionStatus;
import com.backendmarch.librarymanagementsystem.Repository.BookRepository;
import com.backendmarch.librarymanagementsystem.Repository.LibraryCardRepository;
import com.backendmarch.librarymanagementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService
{
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    LibraryCardRepository libraryCardRepository;


    public IssueBookResponseDTO issueBook(IssueBookRequestDTO issueBookRequestDTO) throws Exception
    {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));

        Book book;
        try
        {
            book = bookRepository.findById(issueBookRequestDTO.getBookId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("Book not found");
        }

        LibraryCard card = new LibraryCard();
        try
        {
            card = libraryCardRepository.findById(issueBookRequestDTO.getCardId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("Library Card not found");
        }

        if(card.getCardStatus()!= CardStatus.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Your card is not activated");
        }

        if(book.isIssued())
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry! Book is already issued.");
            transactionRepository.save(transaction);
            throw new Exception("Sorry! Book is already issued.");
        }
        //book can be issued
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was successfull");
        transaction.setBook(book);
        transaction.setLibraryCard(card);

        book.setCard(card);
        book.setIssued(true);
        book.getTransactions().add(transaction);

        card.getTransactions().add(transaction);

        libraryCardRepository.save(card);       //will save book and transaction also

        return new IssueBookResponseDTO(transaction.getId(), book.getTitle(), transaction.getTransactionStatus());
    }

    public ReturnBookReponseDTO returnBook(ReturnBookRequestDTO returnBookRequestDTO)
    {
        Transaction transaction = new Transaction();
        Book book = bookRepository.findById(returnBookRequestDTO.getBookId()).get();
        LibraryCard card = libraryCardRepository.findById(returnBookRequestDTO.getCardId()).get();

        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Return successfull");
        transaction.setBook(book);
        transaction.setLibraryCard(card);

        book.setIssued(false);

        card.getTransactions().add(transaction);

        libraryCardRepository.save(card);

        return new ReturnBookReponseDTO(book.getTitle(), "Return successfull");
    }
}
