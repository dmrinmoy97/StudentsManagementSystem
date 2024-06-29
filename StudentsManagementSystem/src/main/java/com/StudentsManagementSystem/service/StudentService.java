package com.StudentsManagementSystem.service;

import com.StudentsManagementSystem.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getById(int id);

   void deleteById(int id);

}
