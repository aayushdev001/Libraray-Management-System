package com.backendmarch.librarymanagementsystem.Service;

import com.backendmarch.librarymanagementsystem.Entity.Author;
import com.backendmarch.librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService
{
    @Autowired
    AuthorRepository authorRepository;
    
    public String addAuthor(Author author)
    {
        authorRepository.save(author);
        return "SUCCESS";
    }
}
