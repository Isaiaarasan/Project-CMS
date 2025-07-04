package Services;

import Modules.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentServices {

    List <Student> std = new ArrayList<>(
            Arrays.asList(new Student("Guruvel","123cs","Java","guruvel@gmail.com"),
                    new Student("Arasan","124cs","C++","arasan@gmail.com")
            )
    );

    public List<Student> getStudentDetails(){
        return std;
    }


    public List<Student> getStudentCourse(){
        return Collections.singletonList(std.getLast());
    }
}
