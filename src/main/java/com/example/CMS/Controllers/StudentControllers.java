package com.example.CMS.Controllers;

import com.example.CMS.Modules.Student;
import com.example.CMS.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StudentControllers {

    @Autowired
    StudentServices studentService;

    @GetMapping("/")
    public List<Student> getStudentDetails(){
        return studentService.getStudentDetails();
    }

    @GetMapping("/course")
    public List<Student> getStudentCourse(){
        return studentService.getStudentCourse();
    }
}
