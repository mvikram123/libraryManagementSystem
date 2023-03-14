package com.backendMarch.LibraryManagementsystem.Controller;

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
    public String addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
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


}
