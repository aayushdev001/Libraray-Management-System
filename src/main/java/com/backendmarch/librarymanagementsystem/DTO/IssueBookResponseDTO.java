package com.backendmarch.librarymanagementsystem.DTO;

import com.backendmarch.librarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDTO
{
    int transactionId;
    String bookName;
    TransactionStatus transactionStatus;
}
