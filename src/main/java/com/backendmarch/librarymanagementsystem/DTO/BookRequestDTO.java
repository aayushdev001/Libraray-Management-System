package com.backendmarch.librarymanagementsystem.DTO;

import com.backendmarch.librarymanagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookRequestDTO
{
    String title;

    int price;

    Genre genre;

    int authorId;
}
