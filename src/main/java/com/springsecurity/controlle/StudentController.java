package com.springsecurity.controlle;

import com.springsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController{
    List<Student> students =new ArrayList<>();
    @GetMapping("students")
    public List<Student> student(){
        List<Student> students =new ArrayList<>();
        Student student=new Student(100 ,"Rabiul", "abc@gmail.com", "123");
        Student student1=new Student(101 ,"Rabiul", "abc@gmail.com", "123");
        Student student3=new Student(102 ,"Rabiul", "abc@gmail.com", "123");
        students.add(student);
        students.add(student1);
        students.add(student3);
        return students;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("students")
    public Student save(@RequestBody Student student){
        students.add(student);
        return student;
    }

}
