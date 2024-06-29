package com.StudentsManagementSystem.controller;

import com.StudentsManagementSystem.entity.Student;
import com.StudentsManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/students")
    public String getAllStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";//view html page
    }
    @GetMapping("students/new")
    public String createStudentForm(Model model){
        Student student=new Student();
        model.addAttribute("student",student);//to hold student object
        return "create-student";//open create-student page
    }
    @PostMapping("/students")
    public  String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id,Model model){
        model.addAttribute("student",studentService.getById(id));
        return "edit_student";
    }
    @PostMapping("/students/edit/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student){
        Student existingStudent = studentService.getById(id);
        existingStudent.setId(student.getId());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());

        studentService.saveStudent(existingStudent);

        return "redirect:/students";

    }
    @GetMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        studentService.deleteById(id);
        return "redirect:/students";
    }

}
