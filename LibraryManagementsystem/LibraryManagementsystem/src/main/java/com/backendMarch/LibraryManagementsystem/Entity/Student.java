package com.backendMarch.LibraryManagementsystem.Entity;

import com.backendMarch.LibraryManagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;

@Entity
@NoArgsConstructor//do not need to write default contructor
@AllArgsConstructor//do not need to write parameterised constructor
@Getter//do not need to write getter methods

@Setter//do not need to write setter methods
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String name;

   private int age;
   @Column(unique = true)
  private  String mail;
    @Enumerated(EnumType.STRING)
    Department department;
    @OneToOne(mappedBy ="student" , cascade=CascadeType.ALL)
    LibraryCard libraryCard;


}
