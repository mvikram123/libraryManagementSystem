package com.backendMarch.LibraryManagementsystem.Controller;

import com.backendMarch.LibraryManagementsystem.DTO.StudentRequestDto;
import com.backendMarch.LibraryManagementsystem.DTO.StudentResponseDto;
import com.backendMarch.LibraryManagementsystem.DTO.StudentUpdateMailRequestDto;
import com.backendMarch.LibraryManagementsystem.Entity.Student;
import com.backendMarch.LibraryManagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        studentService.addStudent(studentRequestDto);
        return "student is added";
    }
    @GetMapping("/find_by_mail")
    public String findByEmail(@RequestParam("mail") String mail)
    {
        studentService.findByMail(mail);
        return "student is found successfully ";

    }
   // @GetMapping("/find_by_age")
    //public String findByAge(@RequestParam("age"  age)
  //  {
       // return
   // }
    @PutMapping("/update_mail")
    public StudentResponseDto  updateMail(@RequestBody StudentUpdateMailRequestDto studentUpdateMailRequestDto)
    {
        return studentService.updateMail(studentUpdateMailRequestDto);
    }

}
