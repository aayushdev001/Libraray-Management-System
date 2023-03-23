package com.backendmarch.librarymanagementsystem.Controller;

import com.backendmarch.librarymanagementsystem.DTO.IssueBookRequestDTO;
import com.backendmarch.librarymanagementsystem.DTO.IssueBookResponseDTO;
import com.backendmarch.librarymanagementsystem.DTO.ReturnBookReponseDTO;
import com.backendmarch.librarymanagementsystem.DTO.ReturnBookRequestDTO;
import com.backendmarch.librarymanagementsystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController
{
    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public IssueBookResponseDTO issueBook(@RequestBody IssueBookRequestDTO issueBookRequestDTO) throws Exception
    {
        return transactionService.issueBook(issueBookRequestDTO);
    }

    @PostMapping("/return-book")
    public ReturnBookReponseDTO returnBook(@RequestBody ReturnBookRequestDTO returnBookRequestDTO)
    {
        return transactionService.returnBook(returnBookRequestDTO);
    }
}
