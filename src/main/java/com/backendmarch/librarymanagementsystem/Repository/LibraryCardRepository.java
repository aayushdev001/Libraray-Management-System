package com.backendmarch.librarymanagementsystem.Repository;

import com.backendmarch.librarymanagementsystem.Entity.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryCardRepository extends JpaRepository<LibraryCard, Integer>
{
}
