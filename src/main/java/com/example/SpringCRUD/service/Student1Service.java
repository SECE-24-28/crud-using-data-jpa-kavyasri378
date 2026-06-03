package com.example.SpringCRUD.service;

import com.example.SpringCRUD.DTO.StudentDto;
import com.example.SpringCRUD.model.Student1;
import com.example.SpringCRUD.repository.Student1Repo;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Student1Service {
    @Autowired
    Student1Repo student1Repo;

    public List<Student1> getAllStudents() {
        return student1Repo.findAll();
    }

    public String AddStudent(Student1 student1) {
        student1Repo.save(student1);
        return "Added successfull";
    }

    public Student1 getStudentBYid(int rno) {
        return student1Repo.findById(rno).orElse(new Student1());//if the id found it will return record otherwise send the empty student
    }

    public String updateStudent(Student1 student1) {
        student1Repo.save(student1);
        return "Updated";
    }

    public String deleteStudent(int rno) {
        student1Repo.deleteById(rno);
        return "deleted successfully";
    }


    public String deleteall() {
        student1Repo.deleteAll();
        return "deleted successfully";
    }

    public List<Student1> getAllStudentsbygenandtech(String gender, String tech) {
        return student1Repo.findByGenderAndTech(gender,tech);
    }

    public List<Student1> getbyNameAndTech(String name, String tech) {
        return student1Repo.findByNameAndTech(name,tech);
    }

    public List<Student1> getStudentBytech(String tech) {
        return student1Repo.findByTech(tech);
    }

    public List<Student1> getstudByGenAndTech(String gender, String tech) {
        return student1Repo.findByGenAndTech(gender,tech);
    }

    public List<Student1> getStudentByname() {
        return student1Repo.findByName();
    }

    public List<Student1> getByGenger(String gender) {
        return student1Repo.findByGender(gender);
    }

    //DTO
    public StudentDto getAllstudByRno(int rno) {
        Student1 s = student1Repo.findById(rno).orElseThrow();
        return convertStudToDto(s);
    }
    public StudentDto convertStudToDto(Student1 s){
        StudentDto std=new StudentDto();
        std.setRno(s.getRno());
        std.setName(s.getName());
        std.setGender(s.getGender());
        std.setTech(s.getTech());
        std.setEmail(s.getEmail());
        return std;
    }

    public StudentDto addStud(@Valid StudentDto s) {
       Student1 student= student1Repo.save(convertDtoToStud(s));
       return convertStudToDto(student);
    }

    public Student1 convertDtoToStud(StudentDto s){
        Student1 std=new Student1();
        std.setRno(s.getRno());
        std.setName(s.getName());
        std.setGender(s.getGender());
        std.setTech(s.getTech());
        std.setEmail(s.getEmail());
        return std;
    }
//pagination
    public Page<Student1> getBypage(int page, int size) {
        return student1Repo.findAll(PageRequest.of(page, size));//it will decide which page and size of the content to get inside the next page
    }
}
