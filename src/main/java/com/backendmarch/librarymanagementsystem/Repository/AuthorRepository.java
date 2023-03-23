package com.backendmarch.librarymanagementsystem.Repository;

import com.backendmarch.librarymanagementsystem.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{
}
