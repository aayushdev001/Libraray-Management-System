package com.backendmarch.librarymanagementsystem.Entity;

import com.backendmarch.librarymanagementsystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LibraryCard
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated (EnumType.STRING)
    private CardStatus cardStatus;

    @CreationTimestamp
    private Date creationDate;

    @UpdateTimestamp
    private Date updationDate;

    @OneToOne
    @JoinColumn                                          //this will introduce the foreign key
    Student student;

    @OneToMany (mappedBy = "libraryCard", cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @OneToMany (mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
}
