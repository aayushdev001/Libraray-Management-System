package com.backendmarch.librarymanagementsystem.Controller;

import com.backendmarch.librarymanagementsystem.DTO.StudentRequestDTO;
import com.backendmarch.librarymanagementsystem.DTO.StudentResponseDTO;
import com.backendmarch.librarymanagementsystem.DTO.StudentUpdateNameDTO;
import com.backendmarch.librarymanagementsystem.Entity.Student;
import com.backendmarch.librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController
{
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public StudentResponseDTO addStudent(@RequestBody StudentRequestDTO studentRequestDTO)
    {
        return studentService.addStudent(studentRequestDTO);
    }

    @PutMapping("/update-name")
    public StudentResponseDTO updateName(@RequestBody StudentUpdateNameDTO studentUpdateNameDTO)
    {
        return studentService.updateName(studentUpdateNameDTO);
    }
}
