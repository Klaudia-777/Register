package com.school.register.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Grades {
    @Id
    private String id;
    private float grade;
    private double weight;
    @Enumerated(value = EnumType.STRING)
    private SubjectType subject;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;
    private LocalDate date;
}
