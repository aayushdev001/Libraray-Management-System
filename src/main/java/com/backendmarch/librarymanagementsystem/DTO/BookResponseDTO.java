package com.backendmarch.librarymanagementsystem.DTO;

import com.backendmarch.librarymanagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookResponseDTO
{
    String title;
    Genre genre;
    String authorName;
}
