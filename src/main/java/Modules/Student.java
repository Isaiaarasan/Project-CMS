package Modules;

import lombok.Data;

@Data

public class Student {
    private String name;
    private String roll_no;
    private String course ;
    private String email ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student(String name, String roll_no, String course, String email) {
        this.name = name;
        this.roll_no = roll_no;
        this.course = course;
        this.email = email;
    }
}
