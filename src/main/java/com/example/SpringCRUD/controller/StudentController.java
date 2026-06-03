package com.example.SpringCRUD.controller;

import com.example.SpringCRUD.model.Student;
import com.example.SpringCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

//    @GetMapping("/students/{rno}")
//    public Student getStudbyId(@PathVariable("rno") int rollNo){
//        return studentService.getstudbyId(rollNo);
//    }

    @PostMapping("/students")
    public String addStudent(@RequestBody Student stud){
        studentService.addStudent(stud);
        return "added Success";
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
        //return "Updated success";
    }

    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable("rno") int rollNo){
        return studentService.deleteStudent(rollNo);
    }
}
