package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
}
