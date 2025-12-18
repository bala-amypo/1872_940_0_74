package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController{
    @Autowired
    StudentService StudentService;
    @PostMapping("/postdata")
    public Student postdata(@RequestBody Student student){
        return StudentService.saveStudent(student);
    }
}