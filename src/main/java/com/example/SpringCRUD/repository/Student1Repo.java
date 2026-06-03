package com.example.SpringCRUD.repository;


import com.example.SpringCRUD.model.Student1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student1Repo extends JpaRepository<Student1,Integer> {

    List<Student1> findByGenderAndTech(String gender,String tech);
    List<Student1> findByNameAndTech(String name,String tech);
    List<Student1> findByTech(String tech);

    //NAtive Query
    @Query(nativeQuery = true,value="SELECT * FROM Student1 WHERE gender=:gender AND tech=:tech")
    List<Student1> findByGenAndTech(@Param("gender") String gender,@Param("tech") String tech);

    //JPQL Query
    @Query("SELECT s FROM Student1 s WHERE s.name='Harsha'")
    List<Student1> findByName();

    @Query("select s from Student1 s where s.gender=:gender")
    List<Student1> findByGender(@Param("gender") String gender);

}
