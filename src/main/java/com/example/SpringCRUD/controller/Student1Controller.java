package com.example.SpringCRUD.controller;

import com.example.SpringCRUD.DTO.StudentDto;
import com.example.SpringCRUD.model.Student1;
import com.example.SpringCRUD.service.Student1Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Student1Controller {
    @Autowired
    Student1Service student1Service;

    //to get all student in db
    @GetMapping("/get")
    public List<Student1> getAllStudents(){
        return student1Service.getAllStudents();
    }

//    //to get specific student by id
//    @GetMapping("/get/{rno}")
//    public Student1 getStudentBYid(@PathVariable ("rno") int rno){
//        return student1Service.getStudentBYid(rno);
//    }

    //to add the new student in db
    @PostMapping("/create")
    public String AddStudent(@Valid @RequestBody Student1 student1){
        return student1Service.AddStudent(student1);
    }

    //to update the existing student details
    @PutMapping("/update")
    public String UpdateStudent(@RequestBody Student1 student1){
        return student1Service.updateStudent(student1);
    }

    //to delete the specific student by id
    @DeleteMapping("/delete/{rno}")
    public String deleteStudent(@PathVariable("rno") int rno){
        return student1Service.deleteStudent(rno);
    }

    //to delete all student in db
    @DeleteMapping("/delete")
    public String deleteAll(){
        return student1Service.deleteall();
    }

    //custom qoery
    @GetMapping("/get/custom")
    public List<Student1> getStudbygenderandTech(@RequestParam ("gender") String gender,@RequestParam("tech") String tech){
        return student1Service.getAllStudentsbygenandtech(gender,tech);
    }

    @GetMapping("/get/custom1")
    public List<Student1> getByNameAndTech(@RequestParam("name") String name,@RequestParam("tech") String tech){
        return student1Service.getbyNameAndTech(name,tech);
    }

    @GetMapping("/get/tech/{tech}")
    public List<Student1> getstudbyTech(@PathVariable ("tech") String tech){
        return student1Service.getStudentBytech(tech);
    }

    //native query
    @PostMapping("students/filter")
    public List<Student1> getStudentByGenAndTech(@RequestParam String gender,@RequestParam String tech){
        return student1Service.getstudByGenAndTech(gender,tech);
    }

    //JPQL Query
    @GetMapping("/student/name")
    public List<Student1> getStudentByName(){
        return student1Service.getStudentByname();
    }

    @GetMapping("/student/gender")
    public List<Student1> getBygender(@RequestParam String gender)
    {
        return student1Service.getByGenger(gender);
    }

    //DTO
    @GetMapping("/stuents/{rno}")
    public StudentDto getAllStudentByRollNo(@PathVariable("rno") int rno){
        return student1Service.getAllstudByRno(rno);
    }

    @PostMapping("/add")
    public StudentDto addStud(@Valid @RequestBody StudentDto s){
        return student1Service.addStud(s);
    }

    //Pagination
    @GetMapping("/getpages")
    public Page<Student1> getAllstud(@RequestParam("page") int page, @RequestParam("size") int size){
        return student1Service.getBypage(page,size);
    }
}
