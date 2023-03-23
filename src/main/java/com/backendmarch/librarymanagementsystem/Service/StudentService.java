package com.backendmarch.librarymanagementsystem.Service;

import com.backendmarch.librarymanagementsystem.DTO.StudentRequestDTO;
import com.backendmarch.librarymanagementsystem.DTO.StudentResponseDTO;
import com.backendmarch.librarymanagementsystem.DTO.StudentUpdateNameDTO;
import com.backendmarch.librarymanagementsystem.Entity.LibraryCard;
import com.backendmarch.librarymanagementsystem.Entity.Student;
import com.backendmarch.librarymanagementsystem.Enum.CardStatus;
import com.backendmarch.librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{
    @Autowired
    StudentRepository studentRepository;

    public StudentResponseDTO addStudent(StudentRequestDTO studentRequestDTO)
    {
//        LibraryCard card = new LibraryCard();
//        card.setCardStatus(CardStatus.ACTIVATED);
//        card.setStudent(student);
//
//        student.setLibraryCard(card);
//
//        studentRepository.save(student);
//
        Student student = new Student();
        student.setName(studentRequestDTO.getName());
        student.setAge(studentRequestDTO.getAge());
        student.setDepartment(studentRequestDTO.getDepartment());

        LibraryCard card = new LibraryCard();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudent(student);

        student.setLibraryCard(card);
        studentRepository.save(student);

        return new StudentResponseDTO(student.getName(), student.getAge());
    }

    public StudentResponseDTO updateName(StudentUpdateNameDTO studentUpdateNameDTO)
    {
        Student student = studentRepository.findById(studentUpdateNameDTO.getId()).get();
        student.setName(studentUpdateNameDTO.getName());
        studentRepository.save(student);
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(student.getName(), student.getAge());
        return studentResponseDTO;
    }
}
