package com.StudentsManagementSystem.service;

import com.StudentsManagementSystem.entity.Student;
import com.StudentsManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = studentRepository.findAll();
        return list;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getById(int id) {
        return studentRepository.findById(id).get();

    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
