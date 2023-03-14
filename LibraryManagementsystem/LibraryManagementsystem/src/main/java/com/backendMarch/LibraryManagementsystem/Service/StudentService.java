package com.backendMarch.LibraryManagementsystem.Service;

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
    public void addStudent(Student student)
    {
        LibraryCard libraryCard=new LibraryCard();
        libraryCard.setCardStatus(CardStatus.ACTIVATED);
        libraryCard.setValidTill("8/2023");
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);
        studentRepository.save(student);
    }
   public String findByMail(String mail)
   {

       Student student=studentRepository.findByMail(mail);
       return student.getName();
   }
 //  public String findByAge()
}
