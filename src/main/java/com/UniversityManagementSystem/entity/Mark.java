package com.UniversityManagementSystem.entity;

import com.UniversityManagementSystem.enums.ExamType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExamType examType;

    private int obtainMarks;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Semester semester;

}
