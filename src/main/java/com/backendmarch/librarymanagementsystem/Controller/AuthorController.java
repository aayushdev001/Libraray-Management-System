package com.backendmarch.librarymanagementsystem.Controller;

import com.backendmarch.librarymanagementsystem.Entity.Author;
import com.backendmarch.librarymanagementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController
{
    @Autowired
    AuthorService authorService;

    @PostMapping("/add-author")
    public String addAuthor(@RequestBody Author author)
    {
        return authorService.addAuthor(author);
    }
}
