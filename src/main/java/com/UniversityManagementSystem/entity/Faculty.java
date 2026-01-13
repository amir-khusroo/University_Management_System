package com.UniversityManagementSystem.entity;

import jakarta.persistence.*;



@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String profileSummary;

    @ManyToOne
    private Department department;

//
//    @ManyToMany(mappedBy = "faculty" , cascade = CascadeType.ALL)
//    private Subject subject;

}
