package com.StudentsManagementSystem.controller;

import com.StudentsManagementSystem.entity.Student;
import com.StudentsManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        model.addAttribute("students/new",student);//to hold student object
        return "create-student";//open create-student page
    }

}
