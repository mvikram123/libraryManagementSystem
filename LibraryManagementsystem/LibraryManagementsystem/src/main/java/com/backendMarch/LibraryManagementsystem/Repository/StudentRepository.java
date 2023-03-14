package com.backendMarch.LibraryManagementsystem.Repository;

import com.backendMarch.LibraryManagementsystem.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByMail(String mail);
   // List<Student> findByAge(Student age);



}
