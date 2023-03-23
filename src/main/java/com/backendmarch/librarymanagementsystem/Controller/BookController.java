package com.backendmarch.librarymanagementsystem.Controller;

import com.backendmarch.librarymanagementsystem.DTO.BookRequestDTO;
import com.backendmarch.librarymanagementsystem.DTO.BookResponseDTO;
import com.backendmarch.librarymanagementsystem.Entity.Book;
import com.backendmarch.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController
{
    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public BookResponseDTO addBook(@RequestBody BookRequestDTO bookRequestDTO) throws Exception
    {
        return bookService.addBook(bookRequestDTO);
    }
}
