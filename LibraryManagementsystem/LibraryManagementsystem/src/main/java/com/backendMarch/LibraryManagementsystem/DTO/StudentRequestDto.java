package com.backendMarch.LibraryManagementsystem.DTO;

import com.backendMarch.LibraryManagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Enumerated;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {
    private String name;
    private int age;
    private String mail;
    @Enumerated
    Department department;
}
