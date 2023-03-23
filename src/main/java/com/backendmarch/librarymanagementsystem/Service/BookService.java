package com.backendmarch.librarymanagementsystem.Service;

import com.backendmarch.librarymanagementsystem.DTO.BookRequestDTO;
import com.backendmarch.librarymanagementsystem.DTO.BookResponseDTO;
import com.backendmarch.librarymanagementsystem.Entity.Author;
import com.backendmarch.librarymanagementsystem.Entity.Book;
import com.backendmarch.librarymanagementsystem.Repository.AuthorRepository;
import com.backendmarch.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
    @Autowired
    AuthorRepository authorRepository;
    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) throws Exception
    {
//        Author author;
//        author = authorRepository.findById(book.getAuthor().getId()).get();
//        List<Book> list = author.getBooks();
//        list.add(book);
//        authorRepository.save(author);
//        return "SUCCESS";
        Author author;
        try
        {
            author = authorRepository.findById(bookRequestDTO.getAuthorId()).get();
        }
        catch (Exception e)
        {
            throw new Exception("Author not found");
        }

        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setPrice(bookRequestDTO.getPrice());
        book.setIssued(false);
        book.setGenre(bookRequestDTO.getGenre());
        book.setAuthor(author);

        List<Book> books = author.getBooks();
        books.add(book);
        authorRepository.save(author); // will save both book and author

        return new BookResponseDTO(book.getTitle(), book.getGenre(), author.getName());
    }
}
