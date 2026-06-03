package com.example.SpringCRUD.service;

import com.example.SpringCRUD.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
//    List<Student> students= Arrays.asList(
//            new Student(1,"john","java"),
//            new Student(2,"priya","react")
//    );
    static List<Student> students=new ArrayList<>();

    static{
                students.add(new Student(1,"john","java"));
                students.add(new Student(2,"priya","react"));
    }

    public List<Student> getAllStudent() {
        return students;
    }

    public Student getstudbyId(int rollNo) {
        int index=0;
        boolean flag=false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRollNo()==rollNo){
                index=i;
                flag=true;
            }
        }
        if(!flag) return new Student(0,"","");
        else {
            return students.get(index);
        }
    }

    public void addStudent(Student stud) {
        students.add(stud);
    }

    public Student updateStudent(Student student) {
        int index=0;
        boolean flag=false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRollNo()==student.getRollNo()){
//                students.get(i).setName(student.getName());
//                students.get(i).setTech(student.getTech());
                index=i;
                flag=true;
                break;
            }
        }
        if(flag) {
            return students.set(index, student);
        }
        else{
            return new Student(0,"","");
        }
    }

    public String deleteStudent(int rollNo) {
        int index=0;
        boolean flag=false;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getRollNo()==rollNo){
                index=i;
                flag=true;
                break;
            }
        }
        if(flag){
            students.remove(index);
            return "deleted successfully";
        }
        else{
            return "student not found";
        }
    }
}
