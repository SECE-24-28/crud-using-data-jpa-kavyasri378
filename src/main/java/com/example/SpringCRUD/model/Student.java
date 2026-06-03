package com.example.SpringCRUD.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Student {
    private int rollNo;
    private String name;
    private String tech;

    public Student(int rollNo, String name, String tech) {
        this.rollNo = rollNo;
        this.name = name;
        this.tech = tech;
    }

    public Student() {
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
