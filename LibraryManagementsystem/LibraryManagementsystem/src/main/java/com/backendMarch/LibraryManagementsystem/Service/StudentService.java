package com.backendMarch.LibraryManagementsystem.Service;

import com.backendMarch.LibraryManagementsystem.DTO.StudentRequestDto;
import com.backendMarch.LibraryManagementsystem.DTO.StudentResponseDto;
import com.backendMarch.LibraryManagementsystem.DTO.StudentUpdateMailRequestDto;
import com.backendMarch.LibraryManagementsystem.Entity.LibraryCard;
import com.backendMarch.LibraryManagementsystem.Entity.Student;
import com.backendMarch.LibraryManagementsystem.Enum.CardStatus;
import com.backendMarch.LibraryManagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(StudentRequestDto studentRequestDto)
    {
        //create a student object
       Student student=new Student();
       student.setName(studentRequestDto.getName());
       student.setAge(studentRequestDto.getAge());
       student.setMail(studentRequestDto.getMail());
       student.setDepartment(studentRequestDto.getDepartment());

       //create a card object
        LibraryCard libraryCard=new LibraryCard();


        libraryCard.setCardStatus(CardStatus.ACTIVATED);
        student.setLibraryCard(libraryCard);
        studentRepository.save(student);
    }
   public String findByMail(String mail)
   {

       Student student=studentRepository.findByMail(mail);
       return student.getName();
   }
 //  public String findByAge()
    public StudentResponseDto updateMail(StudentUpdateMailRequestDto studentUpdateMailRequestDto)
    {
        Student student=studentRepository.findById(studentUpdateMailRequestDto.getId()).get();
        student.setMail(studentUpdateMailRequestDto.getMail());
        //update Step
        Student updatedStudent=studentRepository.save(student);

        //convert updated student into student response dto
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setMail(updatedStudent.getMail());
        return studentResponseDto;

    }
}
