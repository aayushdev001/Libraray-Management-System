package com.backendmarch.librarymanagementsystem.Entity;

import com.backendmarch.librarymanagementsystem.Enum.CardStatus;
import com.backendmarch.librarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

    @OneToOne (mappedBy = "student", cascade = CascadeType.ALL)
    LibraryCard libraryCard;
}
