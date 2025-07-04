package Controllers;

import Modules.Student;
import Services.StudentServices;
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
