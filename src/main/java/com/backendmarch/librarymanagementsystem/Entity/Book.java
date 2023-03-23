package com.backendmarch.librarymanagementsystem.Entity;

import com.backendmarch.librarymanagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String title;

    private int price;

    private boolean isIssued;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    Author author;

    @OneToMany (mappedBy = "book", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
